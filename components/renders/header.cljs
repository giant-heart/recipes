(ns components.renders.header
  (:require
   ["ink" :refer [render Text Box]]
   ["ink-gradient$default" :as Gradient]
   ["ink-big-text$default" :as BigText]
   [components.state :as state]))

(defn title-block [title font]
  [:> Box
   {:flex-direction "column"}
   [:> Gradient
    {:colors ["#AA0000" "red"]
     :flex-direction "column"}
    [:> Text
     (str " " (:creation-date @state/active-entry*))]]
   [:> Gradient {:colors ["#AA0000" "red"]
                 :flex-direction "column"}
    [:> BigText {:text title
                 :font font}]]])
