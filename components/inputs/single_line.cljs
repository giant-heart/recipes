(ns components.inputs.single-line
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]))

(defn single-line-text-input [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    [:> TextInput
     {:id uid
      :value (if contents contents "")
      :focus (= uid @state/focus)
      :on-up (fn [e] (print uid))
      :on-down (fn [e] (print uid))
      :show-cursor false
      :custom-book-end state/default-book-end
      :on-ctrl-space (fn [e]
                       (ui/switch-focus "command-palette"))
      :on-change (fn [e]
                   (if (or (s/includes? e "\\"))
                     (ui/switch-focus "command-palette")
                     (util/update-surface-contents! entry* uid e)))}]))
