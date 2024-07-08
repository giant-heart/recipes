(ns components.displays.multi-line
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [components.utils :as util]
            [clojure.string :as s]))

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
