(ns components.displays.multi-line
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [components.utils :as util]
            [clojure.string :as s]))

;; This renders a multi-line-display for view in a surface
;; It expects for the contents to be a vector of lines
;; example: [{:value "# Our first line"} {:value "a *second* line"}]

(defn multi-line-text-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    (map-indexed (fn [idx c]
                   [:> Box
                    {:flex-direction "column"
                     :key (str uid "-ml-" idx)}
                    [:> Text
                     {:width 80}
                     (:value c)]]
                   )
                 contents)))


(defn multi-line-print [contents]
  (let [lines (map :value contents)]
    (s/join "\n" lines)))
