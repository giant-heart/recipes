(ns components.renders.editor
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [components.renders.ink-well :as iw]
            [components.renders.command-palette :as c]
            [components.entry-composition :as ec]
            [components.state :as state]
            [reagent.core :as r]))

(def bar-char "▅")

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
    :background-color "teal"
    :padding-left 1
    :padding-right 1}
   (iw/ink-remaining-indicator @state/characters-within-24-hrs*
                               state/max-characters-per-24-hrs)
   (h/title-block state/active-entry* "tiny")
   (entry-surfaces state/active-entry*)
   (c/command-palette state/active-entry*)
   ])
