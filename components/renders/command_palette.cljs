(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :refer [TextInput]]
            [components.ui :as ui]
            [reagent.core :as r]))

(defonce command-text (r/atom ""))

(def suggestion-list ["save and close"])

(defn command-line []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :width "100%"
    :gap 1}
   [:> Box
    [:> Text "💘 "]
    (if (= "command-line" @ui/focus)
      [:> TextInput
       {:suggestions suggestion-list
        :value @command-text
        :is-disabled (not= "command-line" @ui/focus)
        :on-change (fn [e]
                     (reset! command-text e))
        :on-submit (fn [e]
                     (reset! ui/focus "journal-1"))}])]])
