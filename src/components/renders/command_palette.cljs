(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :as ink-ui]
            [components.ui :as ui]
            [components.entry-composition :as ec]
            [components.user-data :as u]
            [components.renders.editor :as ed]
            [reagent.core :as r]
            [components.state :as state]
            [components.exporters.org-roam :as ore]
            [clojure.string :as s]))

(defonce command-text (r/atom ""))

(def commands {"add" (fn [args]
                       (let [surface-type (if (seq args) (first args) "markdown")]
                         (ec/add-surface! state/active-entry* surface-type)))
               "save" (fn [args]
                        (let [contents (ec/extract-contents-from-entry state/active-entry*)
                              chars-in-contents (count contents)]
                          (u/update-save-log! chars-in-contents)
                          (ore/save-org-locally contents
                                                (if (seq args) (s/join " " args)
                                                    (:title @state/active-entry*)))
                          (reset! state/active-entry* (ec/entry "Poem" ""))
                          (ec/add-surface! state/active-entry* "plain")))})

(defn run-command
  "This runs the provided command. If it's a number, then we try to switch focus."
  [cmd-str]
  (if (int? (js/parseInt cmd-str))
    (ui/switch-focus-to-index (js/parseInt cmd-str))
    (let [parsed-command (s/split cmd-str #"\s")
          executed-command (first parsed-command)
          args (rest parsed-command)
          status ((get commands executed-command (fn [a] nil)) args)]
      (ui/switch-focus-to-index 0))))

(def suggestion-list ["add"
                      "add markdown"
                      "add poem"
                      "add plain"
                      "save"])

(defn command-palette []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :border-color (if (= "command-palette" @state/focus) "#FE6D73" "black")
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
