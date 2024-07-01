(ns components.renders.writing-surfaces.plain
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.utils :as u]))

(defonce text-state (r/atom ""))

(defn plain-surface [surface-id]
  (print "plain" @u/focus surface-id (= surface-id @u/focus))
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
     :value @text-state
     :focus (= surface-id @u/focus)
     :on-up (fn [] (print surface-id))
     :on-down (fn [] (print surface-id))
     :on-change (fn [e]
                  (if (s/includes? e "/")
                    (do (u/switch-focus "command-line")
                        (reset! text-state (s/replace e "/" "")))
                    (reset! text-state e)))}]])
