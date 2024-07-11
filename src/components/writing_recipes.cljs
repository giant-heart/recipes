(ns components.writing-recipes
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

(def built-in-recipes
  [{:name "Journal"
    :alias ["j" ""]
    :surfaces [["markdown" "" "every letter is precious"]]}

   {:name "Giant Heart Poem"
    :alias ["ghp"]
    :surfaces [["markdown" "Inspiration" "What's on your mind?"]
               ["poem" "Poem" "art"]
               ["markdown" "Reflection" "What does the poem reveal?"]]}

   {:name "The Work"
    :description "The only time we suffer is when we believe a thought
that argues with what is. \n - Byron Katie"
    :surfaces [["markdown" "What is the thought?" ""]
               ["markdown" "Is it true?" ""]
               ["markdown" "Can you absolutely know that it's true?" ""]
               ["markdown" "How do you react, what happens, when you believe that thought?" ""]
               ["markdown" "Who would you be without the thought?" ""]]}])

(defn get-recipes []
  (let [standard-recipes (lf/read-from-file (str state/user-data-path "recipes.edn"))
        parsed-recipes (edn/read-string standard-recipes)]
    (vec (set (concat built-in-recipes parsed-recipes)))))

(defn get-recipe-by-name [name]
  (let [all-recipes @state/writing-recipes*
        recipe (first (filter (fn [r]
                                (= (s/lower-case name)
                                   (s/lower-case (:name r))))
                              all-recipes))]
    recipe))
