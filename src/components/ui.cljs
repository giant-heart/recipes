(ns components.ui
  (:require [reagent.core :as r]
            [components.state :as state]))

;; These are the functions used to switch focus between inputs.
;; We reference the state atoms directly within the function body
;; which is not very functional, but does simplify changing focus

(defn switch-focus! [target]
  (reset! state/focus target))

(defn switch-focus-to-index! [idx]
  (let [surfaces (:surfaces @state/active-entry*)
        num-surfaces (count surfaces)
        surface-target (if (and (<= idx num-surfaces)
                                (> idx 0))
                         (nth surfaces (dec idx) nil)
                         (if (= idx 0)
                           (nth surfaces (dec num-surfaces) nil)))]
    (if surface-target (switch-focus! (:uid surface-target)) nil)))
