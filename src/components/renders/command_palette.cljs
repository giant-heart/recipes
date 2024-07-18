(ns components.renders.command-palette
  (:require ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :as ink-ui]
            ["shelljs$default" :as sh]
            [components.ui :as ui]
            [components.entry-composition :as ec]
            [components.user-data :as u]
            [reagent.core :as r]
            [components.state :as state]
            [components.exporters.org-roam :as eor]
            [components.exporters.markdown :as emd]
            [clojure.string :as s]))

;; The wonderful command palette.
;; this component allows us to control the application using our custom commands.
;; a trade-off is that we're using the uncontrolled version of the text-input
;; which means that the value of the input is not tied to the value passed to it.
;; for eg. in the markdown input we can change the text to have strike-throughs on backspace
;; but with this input we can only change the text through keyboard input.
;; on the other hand, it has text suggestions, which is very handy for commands.

;; The current value of the command palette input
(defonce command-text (r/atom ""))

(def commands
  "The map of possible commands. A command is a function that takes a list of arguments.
  the name of the command corresponds to what must be typed to invoke it, and the arguments
  are anything following that name. Most commands mutate state, and they should return either
  true or false"
  {
   ;; add a new surface. If a name is provided (eg. poem), then it will add a poem surface
   ;; otherwise it will default to a markdown surface.
   "add" (fn [args]
           (let [surface-type (if (seq args) (first args) "markdown")
                 surface-title (if (seq (rest args)) (s/join " " (rest args)) "")]
             (ec/add-surface! state/active-entry* surface-type surface-title)
             true))

   ;; switches to the help screen, but does not clear the active entry
   ;; useful for checking commands without losing what you were writing.
   "help" (fn [args]
            (reset! state/active-screen* :help)
            true)

   ;; switches back to the editor view
   ;; if we had more views then we would need to implement some history switching
   "close" (fn [args]
             (reset! state/active-screen* :editor)
             true)

   ;; goes adds the next surface in the recipe to the entry
   "next" (fn [args]
            (ec/add-next-surface-in-recipe! state/active-entry*
                                            state/active-recipe*
                                            state/active-recipe-position*)
            true)

   ;; starts a new recipe by name. Defaults to "Journal"
   "start" (fn [args]
             (let [recipe-name (if (seq args) (s/join " " args)
                                   "Journal")]
               (ec/start-recipe! recipe-name)
               true))

   ;; - saves the current entry to disk (currently defaults to org-roam)
   ;; - updates the save-log in the user profile
   ;; - resets the current entry to a new Journal
   "save" (fn [args]
            (let [contents (ec/extract-contents-from-entry state/active-entry*)
                  chars-in-contents (count contents)
                  title (if (seq args) (s/join " " args)
                            (:title @state/active-entry*))]
              (u/update-save-log! chars-in-contents)
              (case @state/default-storage*
                "org-roam" (eor/save-org-locally contents title)
                "markdown" (emd/save-markdown-locally contents title))
              (ec/init-blank-entry!)
              true))

   ;; Clears the current entry and starts a new one of type Journal
   "recycle" (fn [args]
               (ec/init-blank-entry!)
               true)

   "exit" (fn [args]
            (sh/exit 1))})

(defn run-command
  "This runs the provided command. If it's a number, then we try to switch focus."
  [cmd-str]
  (if (int? (js/parseInt cmd-str))
    (ui/switch-focus-to-index! (js/parseInt cmd-str))
    (let [parsed-command (s/split cmd-str #"\s")
          executed-command (first parsed-command)
          args (rest parsed-command)
          status ((get commands executed-command (fn [a] nil)) args)]
      (if status (sh/exec "clear"))
      (ui/switch-focus-to-index! 0))))

(def suggestion-list
  "These are the suggestions that will show. It filters on matching string
  and then goes in order.
  So for example, when you type `a` it will suggest `add`
  then if you added a space to make it `add ` it would suggest `add markdown`
  because `add markdown` is earlier in the list than `add poem`"

  ["add"
   "next"
   "add markdown"
   "add poem"
   "add plain"
   "recycle"
   "save"
   "start"
   "start giant heart poem"
   "start the work"
   "start journal"
   "exit"])

(defn command-palette
  "This is the command-palette that is rendered.
  It uses the @ink-ui/text-input and has a heart icon at the start
  Since we can't clear the text by changing it's value, we stop rendering
  the text-input part of the component when not in use, which effectively clears it."
  []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :border-color (if (= "command-palette" @state/focus*) "#FE6D73" "#aaaaaa")
    :width "100%"
    :gap 1}
   [:> Box
    [:> Text "💘 "]
    (if (= "command-palette" @state/focus*)
      [:> ink-ui/TextInput
       {:suggestions suggestion-list
        :value @command-text
        :is-disabled (not= "command-palette" @state/focus*)
        :on-change (fn [e]
                     (if (and (int? (js/parseInt e))
                              (< (count (:surfaces @state/active-entry*)) 10))
                       (ui/switch-focus-to-index! (js/parseInt e))
                       (reset! command-text e)))
        :on-submit (fn [e]
                     (run-command e))}])]])
