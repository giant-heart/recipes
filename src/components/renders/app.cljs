(ns components.renders.app
  (:require ["ink" :refer [Box]]
            [components.renders.header :as h]
            [components.renders.ink-well :as iw]
            [components.renders.command-palette :as c]
            [components.renders.screens.editor :as e]
            [components.state :as state]
            [reagent.core :as r]))

(defn app [screen]
  (print screen)
  (case screen
    :editor e/writing-area))
