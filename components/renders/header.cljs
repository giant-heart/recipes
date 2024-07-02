(ns components.renders.header
  (:require
   ["ink" :refer [render Text Box]]
   ["ink-gradient$default" :as Gradient]
   ["ink-big-text$default" :as BigText]))

(defn title-block [title font]
  [:> Box
   [:> Gradient {:colors ["#AA0000" "red"]}
    [:> BigText {:text title
                 :font font}]]])
