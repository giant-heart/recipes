(ns components.ui
  (:require [reagent.core :as r]
            [components.state :as state]))


(defn switch-focus [target]
  (print "switching focus to " target)
  (reset! state/focus target))

(defn switch-to-index [idx]
  (let [surfaces (:surfaces @state/active-entry*)
        surface-target (nth surfaces (dec idx))]
    (switch-focus (:uid surface-target))))
