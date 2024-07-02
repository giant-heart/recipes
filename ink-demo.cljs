(ns ink-demo
  (:require ["ink" :refer [render Text Box]]
            #_["ink-text-input$default" :as TextInput]
            ["ink-text-input" :refer [UncontrolledTextInput]]
            ["ink-gradient$default" :as Gradient]
            ["ink-big-text$default" :as BigText]
            ["syllable" :refer [syllable]]
            ["@inkjs/ui" :refer [TextInput]]
            [clojure.string :as s]
            [reagent.core :as r]))

(defonce state (r/atom 0))
(defonce journal-text-area-1 (r/atom ""))
(defonce journal-text-area-2 (r/atom ""))
(defonce active-text-area (r/atom true))

(def count
  (js/setInterval
   #(if (< @state 20)
      (swap! state inc)
      (js/clearInterval count))
   500))


(defn header []
  [:> Box
   [:> Gradient {:name "morning"}
    [:> BigText {:text "giant heart"
                 :font "chrome"}]]])


(defn journal []
  [:> Box
   {:flex-direction "column"
    :border-style "round"
    :background-color "red"
    :width "100%"}
   (header)
   [:> Box
    {:gap 1}
    [:> Text
     (str (syllable @journal-text-area-1))]
    [:> TextInput {:placeholder ""
                   :suggestions ["love" "time"]
                   :on-change (fn [e]
                                (if (s/includes? e "/")
                                  (do (print "input cmd")
                                      (reset! journal-text-area-1 (s/replace e "/" "")))
                                  (reset! journal-text-area-1 e)))
                   :value @journal-text-area-1
                   :on-submit (fn [e]
                                (reset! journal-text-area-1 e))}]]

   #_[:> Box
      {:border-color (if @active-text-area "green")
       :border-style "bold"}
      [:> TextInput {:value @journal-text-area-1
                     :focus @active-text-area
                     :show-cursor false
                     :on-change (fn [e]
                                  (reset! journal-text-area-1 e))
                     :on-submit (fn [e]
                                  (swap! active-text-area not))}]]

   #_[:> Box
      {:border-color (if (not @active-text-area) "green")
       :border-style "bold"}
      [:> TextInput {:value @journal-text-area-2
                     :focus (not @active-text-area)
                     :show-cursor false
                     :on-change (fn [e]
                                  (reset! journal-text-area-2 e))
                     :on-submit (fn [e]
                                  (swap! active-text-area not))}]]

   #_[:> UncontrolledTextInput {:focus true
                                :on-submit (fn [e]
                                             (print e))}]

   #_[:> Text {:color "#FABBBB"} "Hello, world! " @state " " @journal-text-area-1]
   ])

(render (r/as-element [journal]))
