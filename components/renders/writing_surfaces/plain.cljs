(ns components.renders.writing-surfaces.plain
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]))


(defn surface [entry* uid text-input text-display]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    [:> Box
     {:key uid
      :flex-direction "column"
      :border-style "round"
      :width "90%"
      :gap 1}
     [:> Box
      {:justify-content "space-between"}
      [:> Text "Plain"]
      (if (= "command-palette" @state/focus)
        [:> Text
         {:inverse true}
         (str " "(inc surface-position)" ")])]
     (if (= uid @state/focus)
       (text-input entry* uid)
       (text-display entry* uid))]))


(defn plain-text-input [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    [:> TextInput
     {:id "journal-1"
      :placeholder "write here"
      :value (if contents contents "")
      :focus (= uid @state/focus)
      :on-up (fn [e] (print uid))
      :on-down (fn [e] (print uid))
      :on-ctrl-space (fn [e]
                       (ui/switch-focus "command-palette"))
      :on-change (fn [e]
                   (if (or (s/includes? e "/"))
                     (ui/switch-focus "command-palette")
                     (util/update-surface-contents! entry* uid e)))}]))

(defn plain-surface [entry* uid]
  (surface entry* uid plain-text-input plain-text-input))
