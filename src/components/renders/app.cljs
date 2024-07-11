(ns components.renders.app
  (:require ["ink" :refer [Box]]
            [components.renders.header :as h]
            [components.renders.ink-well :as iw]
            [components.renders.command-palette :as c]
            [components.renders.screens.editor :as e]
            [components.renders.screens.help :as h]
            [components.state :as state]
            [reagent.core :as r]))

(defn app [active-screen*]
  (case @active-screen*
    :editor (e/writing-area)
    :help (h/help-area)))
