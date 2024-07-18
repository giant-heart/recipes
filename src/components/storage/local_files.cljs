(ns components.storage.local-files
  (:require ["path" :as path]
            ["zx$fs" :as zxfs]
            [nbb.core :refer [*file*]]))

;; This namespace allows for the saving and reading of files
;; using zxfs which uses fs-extra under the hood.

(defn save-to-file
  "Saves `content` to `file-path`.
  if the path does not exist, it attempts to create it."
  [content file-path]
  (let [file (path/resolve file-path)]
    (zxfs/ensureFile file
                     (fn [err]
                       (when err (print err))
                       true))
    (zxfs/outputFile file
                     content
                     (fn [err]
                       (if err false true)))
    true))

;; If the file does not exist, it attempts to create it.
(defn read-from-file
  "Reads the file at `file-path`
  if the path does not exist, it attempts to create it"
  [file-path]
  (zxfs/ensureFile (path/resolve file-path)
                   (fn [err]
                     (when err (print err))
                     (str (zxfs/readFileSync file-path)))))
