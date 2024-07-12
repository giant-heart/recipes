(ns components.entry-composition
  (:require [components.surfaces.interface :as surfaces]
            [components.displays.interface :as d]
            [components.writing-recipes :as wr]
            [components.state :as state]
            [components.time :as t]
            ["shelljs$default" :as sh]
            [clojure.string :as s]
            [components.ui :as ui]))

(def render-functions {"plain" surfaces/single-line-surface
                       "multi-line" surfaces/multi-line-surface
                       "markdown" surfaces/markdown-surface
                       "poem" surfaces/poem-surface})

(def print-functions {"plain" (fn [e] e)
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
  ""
  [surface-type title]
  {:type surface-type
   :uid (str (random-uuid))
   :render-function (get render-functions surface-type)
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
    (ui/switch-focus (:uid new-surface))))

(defn entry-from-recipe
  "creates an entry based on a provided recipe-name.
  it's case-insensitive and matches on the first result from state/writing-recipes*"
  [recipe-name]
  (let [all-recipes @state/writing-recipes*
        author-name (:name @state/user-data*)
        recipe (first (filter (fn [r]
                                (= (s/lower-case recipe-name)
                                   (s/lower-case (:name r))))
                              all-recipes))]
    (entry (:name recipe) author-name)))

(defn add-next-surface-in-recipe!
  "Given the active entry, recipe and our zero-indexed current position in the recipe
  add the next surface"
  [entry* recipe* idx*]
  (let [surface-title (:name @recipe*)
        recipe-surfaces (:surfaces @recipe*)
        surface-to-add (get recipe-surfaces @idx* nil)]
    (if surface-to-add
      (let [surface-type (first surface-to-add)
            surface-name (second surface-to-add)
            new-surface (surface surface-type surface-name)
            updated-surfaces (conj (vec (get @entry* :surfaces)) new-surface)]
        (swap! idx* inc)
        (swap! entry* assoc :surfaces updated-surfaces)
        (ui/switch-focus (:uid new-surface))))))


(defn extract-contents-from-entry [entry*]
  (let [surfaces (:surfaces @entry*)
        contents (map (fn [s]
                        (let [{:keys [contents type title]} s
                              print-func (get print-functions type)]
                          (str title "\n\n"
                               (print-func contents)))) surfaces)]
    (s/join "\n\n\n" contents)))

(defn start-recipe! [name]
  (sh/exec "clear")
  (reset! state/active-recipe* (wr/get-recipe-by-name name))
  (reset! state/active-entry* (entry-from-recipe name))
  (reset! state/active-recipe-position* 0)
  (add-next-surface-in-recipe! state/active-entry*
                                  state/active-recipe*
                                  state/active-recipe-position*)
  (reset! state/active-screen* :editor))
