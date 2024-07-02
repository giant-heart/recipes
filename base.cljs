(ns giant-heart-journal-base
  (:require [components.renders.editor :as e]
            ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [components.ui :as ui]))

(ui/switch-focus "command-palette")

(render (r/as-element [e/writing-area]))
