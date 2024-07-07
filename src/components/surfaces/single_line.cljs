(ns components.surfaces.single-line
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.surfaces.structure :as structure]
            [components.inputs.single-line :as sl]))

(defn single-line-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     sl/single-line-text-input
                     sl/single-line-text-input))
