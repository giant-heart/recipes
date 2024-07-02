(ns components.renders.writing-surfaces.plain
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]))

(defn update-surface-contents! [entry* surface-uid new-contents]
  (let [updated-surfaces (map (fn [s]
                            (if (= surface-uid (:uid s))
                              (assoc s :contents new-contents) s))
                          (:surfaces @entry*))]
    (swap! entry* assoc :surfaces updated-surfaces)))

(defn plain-surface [entry* uid]
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
     [:> TextInput
      {:id "journal-1"
       :placeholder "write here"
       :value (if contents contents "")
       :focus (= uid @state/focus)
       :on-up (fn [] (print uid))
       :on-down (fn [] (print uid))
       :on-change (fn [e]
                    (if (s/includes? e "/")
                      (ui/switch-focus "command-palette")
                      (update-surface-contents! entry* uid e)))}]]))
