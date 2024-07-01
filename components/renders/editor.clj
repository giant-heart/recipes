(ns components.renders.editor
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [components.renders.writing-surfaces.interface :as ws]
            [components.renders.command-palette :as cp]
            [components.utils :as u]))

(defn writing-area []
  [:> Box
   {:flex-direction "column"
    :border-style "round"}
   (h/title-block "giant heart" "tiny" "morning")
   (cp/command-line)
   (ws/plain-surface "journal-1")
   ])
