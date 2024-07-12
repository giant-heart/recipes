(ns components.renders.app
  (:require ["ink" :refer [Box]]
            [components.renders.header :as h]
            [components.renders.ink-well :as iw]
            [components.renders.command-palette :as c]
            [components.renders.screens.editor :as e]
            [components.renders.screens.help :as h]
            [components.state :as state]
            [reagent.core :as r]))

(defn app
  "This is our router, which decides which screen to display based
  on the state of the atom passed to it.
  If we were to add another screen such as a `:config` screen to allow
  users to change their settings via the TUI then we would add it here."
  [active-screen*]
  (case @active-screen*
    :editor (e/editor-screen)
    :help (h/help-screen)))
