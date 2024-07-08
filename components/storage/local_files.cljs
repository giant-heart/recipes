(ns components.storage.local-files
  (:require ["fs" :as fs]
            ["path" :as path]
            ["shelljs$default" :as sh]
            ["term-size$default" :as term-size]
            ["zx" :refer [$]]
            ["zx$fs" :as zxfs]
            [nbb.core :refer [*file*]]))


(defn save-to-file [content file-path]
  (let [file (path/resolve file-path)]
    (zxfs/outputFile file
                     content
                     (fn [err]
                       (if err false true)))))
