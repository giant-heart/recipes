(ns components.renders.ink-well
  (:require [clojure.math :as m]
            ["ink" :refer [render Text Box]]
            ["@inkjs/ui" :refer [ProgressBar]]
            ["ink-gradient$default" :as Gradient]))

(defn ink-remaining-indicator [current max]
  (let [percentage-complete (int (* 100 (/ current max)))
        percentage-remaining (- 100 percentage-complete)]
    [:> Box {:width "100%"
             :padding-bottom 1
             :padding-right 1}
     [:> Text "🐙 "]
     [:> ProgressBar {:value percentage-remaining}]]))
