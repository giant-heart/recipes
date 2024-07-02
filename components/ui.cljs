(ns components.ui
  (:require [reagent.core :as r]
            [components.state :as state]))


(defn switch-focus [target]
  (print "switching focus to " target)
  (reset! state/focus target))

(defn switch-focus-to-index [idx]
  (let [surfaces (:surfaces @state/active-entry*)
        surface-target (if (and (<= idx (count surfaces))
                                (> idx 0))
                         (nth surfaces (dec idx))
                         false)]
    (print "surface target is " surface-target (count surfaces) idx)
    (if surface-target (switch-focus (:uid surface-target)) nil)))
