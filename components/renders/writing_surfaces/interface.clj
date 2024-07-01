(ns components.renders.writing-surfaces.interface
  (:require [components.renders.writing-surfaces.plain :as wsp]))

#_(def surface-types {:plain plain-surface})

(defn plain-surface [id]
  (wsp/plain-surface id))
