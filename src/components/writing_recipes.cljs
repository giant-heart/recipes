(ns components.writing-recipes
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

(defn get-recipes []
  (let [standard-recipes (lf/read-from-file (str state/user-data-path "recipes.edn"))
        parsed-recipes (edn/read-string standard-recipes)]
    parsed-recipes))

(defn get-recipe-by-name [name]
  (let [all-recipes @state/writing-recipes*
        recipe (first (filter (fn [r]
                                (= (s/lower-case name)
                                   (s/lower-case (:name r))))
                              all-recipes))]
    recipe))
