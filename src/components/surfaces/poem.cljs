(ns components.surfaces.poem
  (:require [components.surfaces.structure :as structure]
            [components.inputs.poem :as pi]
            [components.surfaces.markdown :as mks]
            [components.displays.poem :as pd]))

;; This is the poem surface
;; the display is defined in [[components.inputs.poem]]
;; and the input is modified to use the backspace function
;; defined in the markdown surface.

(defn poem-input [entry* uid]
  (pi/poem-text-input entry* uid mks/markdown-backspace))

(defn poem-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     poem-input
                     pd/poem-display))
