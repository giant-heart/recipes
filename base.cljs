(ns bases.ink
  (:require [components.renders.editor :as e]
            [reagent.core :as r]))

(render (r/as-element [(e/writing-area active-entry*)]))
