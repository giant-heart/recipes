(ns components.renders.editor
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [components.renders.command-palette :as c]
            [components.entry-composition :as ec]
            [components.state :as state]
            [reagent.core :as r]))


(defn entry-surfaces [entry*]
  (let [surfaces (:surfaces @entry*)]
    (map (fn [s]
           (let [{:keys [uid render-function]} s]
             (render-function entry* uid "Page")))
         surfaces)))


(defn writing-area []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :background-color "teal"}
   (h/title-block "Paper Hearts" "tiny")
   (entry-surfaces state/active-entry*)
   (c/command-palette state/active-entry*)
   ])
