(ns components.surfaces.markdown
  (:require ["ink" :refer [render Text Box]]
            [components.surfaces.structure :as structure]
            [components.inputs.multi-line :as mli]
            [components.displays.markdown :as mkd]))

(defn markdown-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     mli/multi-line-text-input
                     mkd/markdown-display))
