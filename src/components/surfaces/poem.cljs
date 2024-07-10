(ns components.surfaces.poem
  (:require [components.surfaces.structure :as structure]
            [components.inputs.poem :as pi]
            [components.surfaces.markdown :as mks]
            [components.displays.poem :as pd]))

(defn poem-input [entry* uid]
  (pi/poem-text-input entry* uid mks/markdown-backspace))

(defn poem-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     poem-input
                     pd/poem-display))
