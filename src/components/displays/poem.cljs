(ns components.displays.poem
  (:require ["ink" :refer [Box]]
            ["ink-markdown$default" :as Markdown]
            [clojure.string :as s]))

;; This renders poem for view in a surface
;; It expects for the contents to be a vector of lines
;; example: [{:value "# Our first line"} {:value "a *second* line"}]

(defn poem-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        contents (:contents this-surface)]
    [:> Box
     {:flex-direction "column"
      :gap 0}
     (map-indexed (fn [idx c]
                    [:> Markdown
                     {:key (str uid "-mkd-" idx)
                      :width 80
                      :reflow-text true}
                     (:value c)]
                    )
                  contents)]))

(defn poem-print [contents]
  (let [lines (map :value contents)]
    (s/join "\n" lines)))
