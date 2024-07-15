(ns components.writing-recipes
  (:require [components.time :as t]
            [clojure.string :as s]
            [components.state :as state]
            [components.storage.local-files :as lf]
            [clojure.edn :as edn]))

;; The heart of the application
;; Recipes allow for moving through a pre-defined writing flow.

(def built-in-recipes
  "These are our built-in recipes
  `name`: what to refer to the recipe as in our title bar, commands and default export
  `alias`: a vector of alternate names for our recipe
  `surfaces`: a vector of the surfaces to be used for each step in our recipe.
              the order here determine the order of steps.
              each surface is a map which contains a:
              `type`: the name of surface-type to surface type to use
                      (corresponds to [[components.entry-composition]])
              `title`: the title to display at the top of the surface, and when exported
              `description`: the description/instructions of the surface (currently unused)"

  [{:name "Journal"
    :alias ["j" ""]
    :surfaces [{:type "markdown", :title "", :description "every letter is precious"}]}

   {:name "Poem"
    :alias ["p" ""]
    :surfaces [{:type "poem", :title "", :description ""}]}

   {:name "Giant Heart Poem"
    :alias ["ghp"]
    :surfaces [{:type "markdown", :title "Inspiration", :description "What's on your mind?"}
               {:type "poem", :title "Poem", :description "art"}
               {:type "markdown", :title "Reflection", :description "What does the poem reveal?"}]}

   {:name "The Work"
    :description "The only time we suffer is when we believe a thought
that argues with what is. \n - Byron Katie"
    :surfaces [{:type "markdown", :title "What is the thought?", :description ""}
               {:type "markdown", :title "Is it true?", :description ""}
               {:type "markdown", :title "Can you absolutely know that it's true?", :description ""}
               {:type "markdown", :title "How do you react, what happens, when you believe that thought?", :description ""}
               {:type "markdown", :title "Who would you be without the thought?", :description ""}]}])


(defn get-recipes
  "this reads user-defined recipes from recipes.edn stored at the user-data-path
  and the combines it with our built-in recipes."
  []
  (let [standard-recipes (lf/read-from-file (str state/user-data-path "recipes.edn"))
        parsed-recipes (edn/read-string standard-recipes)]
    (vec (set (concat built-in-recipes parsed-recipes)))))

(defn get-recipe-by-name
  "gets a recipe by it's name based on the recipes stored in `state/writing-recipes*`
  It's case-insensitive, prefers the first match, and will also match on aliases"
  [name]
  (let [all-recipes @state/writing-recipes*
        recipe (first (filter (fn [r]
                                (let [target-name (s/lower-case name)
                                      recipe-name (s/lower-case (:name r))
                                      recipe-aliases (:alias r)
                                      recipe-alias-set (if (seq recipe-aliases)
                                                         (set (map s/lower-case recipe-aliases))
                                                         #{})]
                                  (or (= target-name recipe-name)
                                      (contains? recipe-alias-set target-name))))
                              all-recipes))]
    (if recipe recipe (first all-recipes))))
