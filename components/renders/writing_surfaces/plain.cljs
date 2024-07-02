(ns components.renders.writing-surfaces.plain
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]))

(defn update-surface-contents! [entry* surface-uid new-contents]
  (let [updated-surfaces (map (fn [s]
                            (if (= surface-uid (:uid s))
                              (assoc s :contents new-contents) s))
                          (:surfaces @entry*))]
    (swap! entry* assoc :surfaces updated-surfaces)))

(defn plain-surface [data entry*]
  (let [{:keys [uid contents]} data]
    [:> Box
     {:flex-direction "column"
      :border-style "round"
      :width "90%"
      :gap 1}
     [:> Text
      "Plain"]
     [:> TextInput
      {:id "journal-1"
       :placeholder "write here"
       :value (if contents contents "")
       :focus (= uid @ui/focus)
       :on-up (fn [] (print uid))
       :on-down (fn [] (print uid))
       :on-change (fn [e]
                    (if (s/includes? e "/")
                      (ui/switch-focus "command-line")
                      (update-surface-contents! entry* uid e)))}]]))
