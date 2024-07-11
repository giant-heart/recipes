(ns components.renders.header
  (:require
   ["ink" :refer [render Text Box]]
   ["ink-gradient$default" :as Gradient]
   ["ink-big-text$default" :as BigText]))

(defn title-block [active-entry* font]
  [:> Box
   {:flex-direction "row"
    :justify-content "space-between"
    :width "100%"}
   [:> Gradient {:colors ["#AA0000" "red"]
                 :flex-direction "column"}
    [:> Text (:title @active-entry*)]]

   [:> Gradient
    {:colors ["#AA0000" "red"]
     :flex-direction "column"}
    [:> Text
     (:creation-date @active-entry*)]]])
