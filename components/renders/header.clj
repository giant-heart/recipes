(ns components.renders.header
  (:require
   ["ink" :refer [render Text Box]]
   ["ink-gradient$default" :as Gradient]
   ["ink-big-text$default" :as BigText]))

(defn title-block [title font gradient]
  [:> Box
   [:> Gradient {:name gradient}
    [:> BigText {:text title
                 :font font}]]])
