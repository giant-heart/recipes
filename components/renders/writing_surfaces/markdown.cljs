(ns components.renders.writing-surfaces.markdown
  (:require ["ink" :refer [render Text Box]]
            ["ink-text-input$default" :as TextInput]
            [reagent.core :as r]
            [clojure.string :as s]
            [components.ui :as ui]
            [components.utils :as util]
            [components.state :as state]
            [components.renders.writing-surfaces.plain :as plain]
            ["ink-markdown$default" :as Markdown]
            ["dedent$default" :as dedent]))

(defn markdown-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        surface-position (util/position-of-surface uid all-surfaces)
        contents (:contents this-surface)]
    [:> Markdown contents]))

(defn markdown-surface [entry* uid]
  (plain/surface entry* uid plain/text-input markdown-display))
