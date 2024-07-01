(ns giant-heart-journal-base
  (:require [components.renders.editor :as e]
            ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [components.utils :as u]))

(print (first *command-line-args*))

(u/switch-focus "journal-1")
(render (r/as-element [e/writing-area]))
