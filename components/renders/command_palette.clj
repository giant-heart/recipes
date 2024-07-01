(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :refer [TextInput]]
            [components.utils :as u]
            [reagent.core :as r]))

(defonce command-text (r/atom ""))
(def suggestion-list ["save and close"])

(defn command-line []
  (print "command-line " (not= "command-line" @u/focus))
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :width "100%"
    :gap 1}
   [:> Box
    {:gap 1}
    [:> Text ">"]
    [:> TextInput
     {:suggestions suggestion-list
      :value @command-text
      :is-disabled (not= "command-line" @u/focus)
      :on-change (fn [e]
                   (reset! command-text e))
      :on-submit (fn [e]
                   (print e))}]]])
