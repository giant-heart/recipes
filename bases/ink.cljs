(ns bases.ink
  (:require [components.renders.editor :as e]
            [components.entry-composition :as ec]
            ["ink" :refer [render]]
            [reagent.core :as r]
            [components.state :as state]))

(reset! state/active-entry* (ec/create-entry "Ada"))

(render (r/as-element [e/writing-area]))
