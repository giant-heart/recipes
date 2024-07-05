(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :as ink-ui]
            [components.ui :as ui]
            [components.entry-composition :as ec]
            [components.renders.editor :as ed]
            [reagent.core :as r]
            [components.state :as state]))

(defonce command-text (r/atom ""))

(def commands {"add" (fn [] (ec/add-surface! state/active-entry* "plain"))})

(defn run-command [cmd]
  (if (int? (js/parseInt cmd))
    (ui/switch-focus-to-index (js/parseInt cmd))
    ((get commands cmd #()))))

(def suggestion-list ["add"
                      "add words"
                      "add dream"
                      "add poem"])

(defn command-palette []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :width "100%"
    :gap 1}
   [:> Box
    [:> Text "💘 "]
    (if (= "command-palette" @state/focus)
      [:> ink-ui/TextInput
       {:suggestions suggestion-list
        :value @command-text
        :is-disabled (not= "command-palette" @state/focus)
        :on-change (fn [e]
                     (if (and (int? (js/parseInt e))
                              (< (count (:surfaces @state/active-entry*)) 10))
                       (ui/switch-focus-to-index (js/parseInt e))
                       (reset! command-text e)))
        :on-submit (fn [e]
                     (run-command e))}])]])
