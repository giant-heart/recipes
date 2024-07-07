(ns components.displays.markdown
  (:require ["ink" :refer [Box]]
            ["ink-markdown$default" :as Markdown]))

;; This renders markdown for view in a surface
;; It expects for the contents to be a vector of lines
;; example: [{:value "# Our first line"} {:value "a *second* line"}]

(defn markdown-display [entry* uid]
  (let [all-surfaces (:surfaces @entry*)
        this-surface (first (filter (fn [s] (= (:uid s) uid))
                                    all-surfaces))
        contents (:contents this-surface)]
    (map-indexed (fn [idx c]
                   [:> Box
                    {:flex-direction "column"
                     :key (str uid "-mkd-" idx)}
                    [:> Markdown
                     {:width 80
                      :reflow-text true}
                     (:value c)]]
                   )
                 contents)))
