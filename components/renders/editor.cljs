(ns components.renders.editor
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [components.renders.writing-surfaces.interface :as ws]
            [components.renders.command-palette :as c]
            [components.entry-composition :as ec]
            #_[components.ui :as ui]
            [reagent.core :as r]))

(defonce active-entry* (r/atom (ec/create-entry "Ada")))

(ec/add-surface active-entry* "plain")

(defn entry-surfaces [entry]
  (let [surfaces (:surfaces @entry)]
    (print surfaces)))

(entry-surfaces active-entry*)

(defn writing-area []
  [:> Box
   {:flex-direction "column"
    :border-style "round"}
   (h/title-block "giant heart journal" "tiny")
   #_(entry-surfaces active-entry*)
   (c/command-line active-entry*)
   ])
