(ns components.ui
  (:require [reagent.core :as r]
            [components.state :as state]))


(defn switch-focus [target]
  (reset! state/focus target))

(defn switch-focus-to-index [idx]
  (let [surfaces (:surfaces @state/active-entry*)
        num-surfaces (count surfaces)
        surface-target (if (and (<= idx num-surfaces)
                                (> idx 0))
                         (nth surfaces (dec idx))
                         (if (= idx 0)
                           (nth surfaces (dec num-surfaces))))]
    (if surface-target (switch-focus (:uid surface-target)) nil)))
