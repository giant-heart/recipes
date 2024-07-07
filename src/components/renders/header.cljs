(ns components.renders.header
  (:require
   ["ink" :refer [render Text Box]]
   ["ink-gradient$default" :as Gradient]
   ["ink-big-text$default" :as BigText]
   [components.state :as state]))

(defn title-block [title font]
  [:> Box
   {:flex-direction "row"
    :padding-left 1
    :padding-right 1
    :justify-content "space-between"}
   [:> Gradient {:colors ["#AA0000" "red"]
                 :flex-direction "column"}
    [:> Text title]]

   [:> Gradient
    {:colors ["#AA0000" "red"]
     :flex-direction "column"}
    [:> Text
     (:creation-date @state/active-entry*)]]])
