(ns components.ui
  (:require [reagent.core :as r]
            [components.state :as state]))

;; These are the functions used to switch focus between inputs.
;; We reference the state atoms directly within the function body
;; which is not very functional, but does simplify changing focus

(defn switch-focus!
  "Changes input focus to the surface with a uid of `target`"
  [target]
  (reset! state/focus* target))


(defn switch-focus-to-index!
  "Changes the input focus to the surface at position `idx` in the current entry"
  [idx]
  (let [surfaces (:surfaces @state/active-entry*)
        num-surfaces (count surfaces)
        surface-target (if (and (<= idx num-surfaces)
                                (> idx 0))
                         (nth surfaces (dec idx) nil)
                         (if (= idx 0)
                           (nth surfaces (dec num-surfaces) nil)))]
    (if surface-target (switch-focus! (:uid surface-target)) nil)))


(defn switch-screen!
  "Changes the active screen to be `target` if not already there."
  [target]
  (if (not= @state/active-screen* target)
    (reset! state/active-screen* target)))
