(ns components.surfaces.structure
  (:require ["ink" :refer [render Text Box]]
            ["ink-markdown$default" :as Markdown]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]))

(defn surface
  "Create a surface to be rendered [[components.entry-composition/entry]]. It accepts
  - `title` to be used as a header,
  - `entry*`: and atom where state is stored
  - `uid`: an identifier to assign to the surface
  - `text-input`: the component to use when editing
  - `text-display`: the component to use when displaying
  It is the skeleton that we use for all other surfaces."
  [title entry* uid input display]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)
        has-title? (if (seq title) true false)]
    [:> Box
     {:key uid
      :flex-direction "column"
      :border-style "round"
      :width "100%"
      :gap 1}
     [:> Box
      {:justify-content (if has-title? "space-between" "flex-end")}
      (if has-title? [:> Markdown (str "**" title "**")])
      (if (= "command-palette" @state/focus)
        [:> Text
         {:inverse true}
         (str " "(inc surface-position)" ")])]
     (if (= uid @state/focus)
       (input entry* uid)
       (display entry* uid))]))
