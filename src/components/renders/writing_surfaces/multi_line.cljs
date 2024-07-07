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
  (let [active-line (nth @lines* idx)
        updated-line (assoc active-line :value new-text)
        new-lines (assoc @lines* idx updated-line)]
    (reset! lines* new-lines)
    new-lines))

(defn add-line! [lines* uid current-idx]
  (let [current-lines @lines*
        lines-without-focus (vec (map (fn [l]
                                        (assoc l :focus false)) current-lines))
        next-index (inc current-idx)
        new-lines (util/insert-at-index lines-without-focus
                                             next-index
                                             (create-line uid next-index))]
    (reset! lines* new-lines)
    new-lines))

(defn multi-line-text-input [entry* uid & [update-function]]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)
        lines* (r/atom (if (seq contents) contents [(create-line uid 0)]))]
    (map-indexed (fn [idx line]
                   [:> TextInput
                    (conj line
                          {:key (str uid "-input-" idx)
                           :on-change (fn [e]
                                        (util/update-surface-contents! entry*
                                                                       uid
                                                                       (update-line!
                                                                        lines*
                                                                        idx
                                                                        e)))

                           :show-cursor false

                           :enable-backspace true

                           :custom-book-end state/custom-book-end

                           :on-submit (fn []
                                        (util/update-surface-contents! entry*
                                                                       uid
                                                                       (add-line! lines* uid idx))
                                        )
                           :on-ctrl-space (fn [e]
                                            (ui/switch-focus "command-palette"))})])
         @lines*)
    ))

(defn multi-line-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    (map-indexed (fn [idx c]
                   [:> Box
                    {:flex-direction "column"
                     :key (str uid "-mkd-" idx)}
                    [:> Text
                     {:width 80}
                     (:value c)]]
                   )
                 contents)))

(defn multi-line-surface [entry* uid]
  (plain/surface entry* uid multi-line-text-input multi-line-text-input))
