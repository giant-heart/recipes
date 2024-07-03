(ns components.renders.writing-surfaces.multi-line
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.renders.writing-surfaces.plain :as plain]))

(defn create-line [uid idx]
  {:id (str uid "-" idx)
   :value ""
   :focus true})

(defn update-line! [lines* idx new-text]
  (print "updating lines" @lines* " with " idx new-text)
  (let [active-line (nth @lines* idx)
        updated-line (assoc active-line :value new-text)
        new-lines (assoc @lines* idx updated-line)]
    (print "new lines are " new-lines)
    (reset! lines* new-lines)
    new-lines))

(defn multi-line-text-input [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)
        lines* (r/atom (if (seq contents) contents [(create-line uid 0)]))]
    (map-indexed (fn [idx line]
                   (print "line is " line)
                   [:> TextInput
                    (conj line
                          {:on-change (fn [e]
                                        (util/update-surface-contents! entry*
                                                                  uid
                                                                  (update-line! lines*
                                                                                idx
                                                                                e)))})])
         @lines*)
    ))

(defn multi-line-surface [entry* uid]
  (plain/surface entry* uid multi-line-text-input multi-line-text-input))
