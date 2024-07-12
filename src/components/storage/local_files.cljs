(ns components.storage.local-files
  (:require ["path" :as path]
            ["zx$fs" :as zxfs]
            [nbb.core :refer [*file*]]))

;; This namespace allows for the saving and reading of files
;; using zxfs which uses fs-extra under the hood.

(defn save-to-file [content file-path]
  (let [file (path/resolve file-path)]
    (zxfs/outputFile file
                     content
                     (fn [err]
                       (if err false true)))
    true))

;; This function could be improved to allow it to create the file
;; if it does not exist since we use it to read config files/user data.
(defn read-from-file [file-path]
  (str (zxfs/readFileSync file-path)))
