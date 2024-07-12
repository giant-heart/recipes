(ns components.renders.screens.editor
  (:require [components.renders.header :as h]
            ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [components.renders.ink-well :as iw]
            [components.renders.command-palette :as c]
            [components.entry-composition :as ec]
            [components.state :as state]
            [reagent.core :as r]))

;; This represents the editor-screen.
;; It's the main interface that we use to write entries
;; It contains **everything** that is rendered on the screen at a time
;; even the header and command-palette.
;; A pragmatic decision was to allow for some code duplication in the screen
;; composition since we already had so many abstractions at the levels that
;; actually need flexibility, ie the surfaces.

(defn entry-surfaces
  "Given the active entry, get all the surfaces, and then render them
  with the appropriate render-function"
  [entry*]
  (let [surfaces (:surfaces @entry*)]
    (if (seq surfaces)
      (map (fn [s]
             (let [{:keys [uid render-function title]} s]
               (render-function entry* uid title)))
           surfaces)
      nil)))


(defn editor-screen
  "this returns the components necessary to render the editor view.
  Note the commented out ink-remaining indicator. Uncommenting it will only render the
  progress bar, but won't stop writing when it's done because we changed the input components to ignore it.
  "
  []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :background-color "teal"
    :width "100%"
    :padding-left 1
    :padding-right 1}
   #_(iw/ink-remaining-indicator @state/characters-within-24-hrs*
                               state/max-characters-per-24-hrs)
   (h/title-block state/active-entry* "tiny")
   (entry-surfaces state/active-entry*)
   (c/command-palette state/active-entry*)
   ])
