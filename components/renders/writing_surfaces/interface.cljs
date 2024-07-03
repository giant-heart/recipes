(ns components.renders.writing-surfaces.interface
  (:require [components.renders.writing-surfaces.plain :as wsp]
            [components.renders.writing-surfaces.markdown :as wsm]))

#_(def surface-types {:plain plain-surface})

(defn plain-surface [entry* uid]
  (wsp/plain-surface entry* uid))

(defn markdown-surface [entry* uid]
  (wsm/markdown-surface entry* uid))
