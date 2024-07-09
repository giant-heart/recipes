(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :as ink-ui]
            [components.ui :as ui]
            [components.entry-composition :as ec]
            [components.renders.editor :as ed]
            [reagent.core :as r]
            [components.state :as state]
            [components.exporters.org-roam :as ore]
            [clojure.string :as s]))

(defonce command-text (r/atom ""))

(def commands {"add" (fn [] (ec/add-surface! state/active-entry* "markdown"))
               "save" (fn [args]
                        (let [contents (ec/extract-contents-from-entry state/active-entry*)]
                          (ore/save-org-locally contents
                                                (if (seq args) (s/join " " args)
                                                    (:title @state/active-entry*)))))})

(defn run-command
  "This runs the provided command. If it's a number, then we try to switch focus."
  [cmd-str]
  (if (int? (js/parseInt cmd-str))
    (ui/switch-focus-to-index (js/parseInt cmd-str))
    (let [parsed-command (s/split cmd-str #"\s")
          executed-command (first parsed-command)
          args (rest parsed-command)
          status ((get commands executed-command) args)]
      (ui/switch-focus-to-index 0)
      )))

(def suggestion-list ["add"
                      "save"])

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
