(ns components.entry-composition
  (:require [components.surfaces.interface :as surfaces]
            [components.displays.interface :as d]
            [components.writing-recipes :as wr]
            [components.state :as state]
            [components.time :as t]
            ["shelljs$default" :as sh]
            [clojure.string :as s]
            [components.ui :as ui]))

(def render-functions
  "The functions to render the surface on the screen. It includes an
  input for when it's active, and a display for when it's inactive."
  {"plain" surfaces/single-line-surface
   "multi-line" surfaces/multi-line-surface
   "markdown" surfaces/markdown-surface
   "poem" surfaces/poem-surface})

(def print-functions
  "The functions to extract the contents of a surface for export."
  {"plain" (fn [e] e)
   "multi-line" d/multi-line-print
   "poem" d/multi-line-print
   "markdown" d/markdown-print})

(defn entry
  "the named group of all the surfaces present.
  It's the unit that we render and perform export on. This allows us to
  customize the recipes on the fly, by adding additional surfaces
  without losing our place in the active recipe."
  [title author-name]
  {:title title
   :creation-date (t/todays-date)
   :surfaces []
   :author author-name})

(defn surface
  "the data structure for each surface. It takes the type of surface and a title
   and returns a map populated with a new uuid, the print, and the render functions"
  [surface-type title]
  {:type surface-type
   :uid (str (random-uuid))
   :render-function (get render-functions surface-type)
   :print-function (get print-functions surface-type)
   :title title
   :contents nil})

(defn add-surface!
  "adds a surface to the entry atom supplied
  Of note is the :render-function which references a def defined above."
  [entry* surface-type & title]
  (let [surface-title (if (seq title) (first title) "")
        new-surface (surface surface-type
                             surface-title)
        updated-surfaces (conj (vec (get @entry* :surfaces)) new-surface)]
    (swap! entry* assoc :surfaces updated-surfaces)
    (ui/switch-focus! (:uid new-surface))))

(defn entry-from-recipe
  "creates an entry based on a provided recipe-name.
  it's case-insensitive and matches on the first result from state/writing-recipes*"
  [recipe-name]
  (let [all-recipes @state/writing-recipes*
        author-name (:name @state/user-data*)
        recipe (wr/get-recipe-by-name recipe-name)]
    (if recipe
      (entry (:name recipe) author-name)
      (entry "Journal" author-name))))

(defn add-next-surface-in-recipe!
  "Given the active entry, recipe and our zero-indexed current position in the recipe
  add the next surface"
  [entry* recipe* idx*]
  (let [surface-title (:name @recipe*)
        recipe-surfaces (:surfaces @recipe*)
        surface-to-add (get recipe-surfaces @idx* nil)]
    (if surface-to-add
      (let [surface-type (:type surface-to-add)
            surface-name (:title surface-to-add)
            new-surface (surface surface-type surface-name)
            updated-surfaces (conj (vec (get @entry* :surfaces)) new-surface)]
        (swap! idx* inc)
        (swap! entry* assoc :surfaces updated-surfaces)
        (ui/switch-focus! (:uid new-surface))))))


(defn extract-contents-from-entry
  "Extracts the contents from an entry for storage. This is helpful since different
  surface types might have different content structures. For example, a single line input might be represented as a string, but a multi-line input might be represented as a vector of strings."
  [entry*]
  (let [surfaces (:surfaces @entry*)
        contents (map (fn [s]
                        (print "extracting contents for " s)
                        (let [{:keys [contents type title print-function]} s
                              title-for-print (if (seq title) (str title "\n") nil)]
                          (str title-for-print
                               (print-function contents)))) surfaces)]
    (s/join "\n\n" contents)))

(defn start-recipe!
  "Replaces the active recipe with a recipe that matches the name provided,
  and then it adds the first surface in the recipe."
  [name]
  (sh/exec "clear")
  (let [active-recipe (wr/get-recipe-by-name name)]
    (reset! state/active-recipe* active-recipe)
    (reset! state/active-entry* (entry-from-recipe (:name active-recipe)))
    (reset! state/active-recipe-position* 0)
    (add-next-surface-in-recipe! state/active-entry*
                                 state/active-recipe*
                                 state/active-recipe-position*)
    (reset! state/active-screen* :editor)))
