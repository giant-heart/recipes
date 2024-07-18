(ns components.exporters.markdown
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]))

(defn file-name
  "creates a properly formatted file-name which includes the current time
  and a title that escapes spaces to be underscores"
  [title ctime]
  (let [formatted-title (s/replace title " " "_")]
    (str formatted-title "-" ctime ".md")))


(defn save-markdown-locally
  "Given a text and a title save it to disk."
  [text title]
  (let [ctime (t/current-ctime)
        file-path (str @state/markdown-storage-path* (file-name title ctime))]
    (lf/save-to-file text file-path)))
