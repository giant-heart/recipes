(ns components.surfaces.plain
  (:require ["ink" :refer [render Text Box]]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.surfaces.structure :as structure]
            [components.inputs.single-line :as sl]))

(defn plain-surface [entry* uid]
  (structure/surface "Plain"
                     entry*
                     uid
                     sl/single-line-text-input
                     sl/single-line-text-input))
