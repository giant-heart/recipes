(ns dev.file-storage
  (:require ["fs" :as fs]
            [components.time :as t]
            [components.exporters.org-roam :as org-roam]
            ["path" :as path]
            ["shelljs$default" :as sh]
            ["term-size$default" :as term-size]
            ["zx" :refer [$]]
            ["zx$fs" :as zxfs]
            [nbb.core :refer [*file*]]))

(prn (path/resolve "."))

(prn (term-size))

#_(println (str (fs/readFileSync *file*)))

(prn (sh/ls "."))

(prn (zxfs/existsSync *file*))

($ #js ["ls"])

(def file (str (path/resolve ".") "/hello.txt"))

(zxfs/outputFile
 file
 "hello!"
 (fn [err]
   (.log js/console err)
   (zxfs/readFile
    file
    "utf8"
    (fn [err data]
      (when err (.error js/console err))
      (.log js/console data)))))

(print (t/current-ctime))

(print (org-roam/metadata "a new day"))
(print (org-roam/metadata "a new day with tags" ["hello" "world"]))
