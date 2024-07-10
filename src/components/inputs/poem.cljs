(ns components.inputs.poem
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            ["syllable" :refer [syllable]]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]))

(defn create-line [uid idx]
  {:id (str uid "-" idx)
   :value ""
   :focus true})

(defn remaining-chars? []
  (< 0 (- state/max-characters-per-24-hrs
          @state/characters-within-24-hrs*)))

(defn update-line! [lines* idx new-text]
  (let [active-line (nth @lines* idx)
        updated-line (assoc active-line :value new-text)
        new-lines (assoc @lines* idx updated-line)]
    (if (remaining-chars?)
      (do
        (swap! state/characters-within-24-hrs* inc)
        (reset! lines* new-lines)))
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

(defn calc-syllables [line]
  (let [text (:value line)
        words-without-strikethrough (s/replace text #"(\*|\~)+(\S+)(\*|\~)+" "")]
    (syllable words-without-strikethrough)))

(defn poem-text-input [entry* uid & backspace-function]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)
        lines* (r/atom (if (seq contents) contents [(create-line uid 0)]))
        backspace-function (if (seq backspace-function)
                             (first backspace-function)
                             (fn [e] e))]
    [:> Box
     {:gap 0
      :flex-direction "column"}
     (map-indexed (fn [idx line]
                    [:> Box
                     {:gap 1
                      :key (str uid "-line-" idx)}
                     [:> Box
                      {:width 2}
                      [:> Text
                       {:dim-olor true
                        :color "#777777"}
                       (str (calc-syllables line))]]
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

                             :allow-change (remaining-chars?)

                             :placeholder (if (= 0 idx)
                                            (str "every letter is precious, so make the most of it." state/default-book-end)
                                            nil)

                             :on-backspace (fn [e]
                                             (util/update-surface-contents! entry*
                                                                            uid
                                                                            (update-line!
                                                                             lines*
                                                                             idx
                                                                             (backspace-function e))))

                             :custom-book-end state/default-book-end

                             :on-submit (fn []
                                          (util/update-surface-contents! entry*
                                                                         uid
                                                                         (add-line! lines* uid idx))
                                          )
                             :on-ctrl-space (fn [e]
                                              (ui/switch-focus "command-palette"))})]])
                  @lines*)]
    ))