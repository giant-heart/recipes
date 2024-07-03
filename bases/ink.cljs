(ns bases.ink
  (:require [components.renders.editor :as e]
            [components.entry-composition :as ec]
            ["ink" :refer [render]]
            [reagent.core :as r]
            [components.state :as state]
            [babashka.cli :as cli]))

(reset! state/active-entry* (ec/create-entry "Ada"))

(let [init-surface-type (first *command-line-args*)]
  (if init-surface-type
    (ec/add-surface state/active-entry* init-surface-type)
    (ec/add-surface state/active-entry* "plain")))

(render (r/as-element [e/writing-area]))
