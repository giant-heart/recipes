(ns components.surfaces.single-line
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.surfaces.structure :as structure]
            [components.inputs.single-line :as sl]))

;; A single line input
;; of note is that it does not take a backspace function
;; and thus allows for backspacing.

(defn single-line-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     sl/single-line-text-input
                     sl/single-line-text-input))
