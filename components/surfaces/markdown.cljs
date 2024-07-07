(ns components.surfaces.markdown
  (:require ["ink" :refer [render Text Box]]
            [components.surfaces.structure :as structure]
            [components.inputs.multi-line :as mli]
            [components.displays.markdown :as mkd]
            [components.utils :as util]
            [clojure.string :as s]))

(defn strikethrough-last-word [text]
  (let [words (s/split text #" ")
        last-word (last words)
        st-last-word (str (if (s/starts-with? last-word "~") nil "~")
                          last-word
                          (if (s/ends-with? last-word "~") nil "~"))]
    (s/join " " (assoc words (dec (count words)) st-last-word))))

(defn find-closing-word [words]
  (first (util/positions (fn [w] (s/ends-with? w "~"))
                    words)))

(defn markdown-backspace [text]
  ;; if the last word in the text has not been strikedthrough
  (if (not (s/ends-with? text "~"))
    (strikethrough-last-word text)
    ;; then we strikethrough it.
    ;; eg "hello wonderful world" => "hello wonderful ~world~"

    ;; else we already have some words in a "strikethrough region"
    ;; which might look like "she sells ~sea shells~"
    ;; where two words have already been deleted.
    ;; so we want to "grow that region" by one word
    ;; ie. "she ~sells sea shells~"

    ;; our first step is to reverse the text for easier manipulation
    ;; then we split it into an array of words ["~sllehs" "aes~" "slles" "ehs"]
    ;; and find the word that would be the end of our current backspace-region
    (let [reversed-text (s/reverse text)
          words (s/split reversed-text #"\s")
          pos-of-closing-word (find-closing-word words)]

      ;; if that word is the end of the text
      ;; return the text cause there's nothing else to backspace
      (if (= pos-of-closing-word (dec (count words)))
        text

        ;; else we get the old closing word
        ;; ie ["~sllehs" "aes~" "slles" "ehs"] => "aes~"
        ;; and remove the old closing tilde => "aes"
        (let [closing-word (nth words pos-of-closing-word)
              closing-word-without-tilde (s/join "" (drop-last closing-word))

              ;; because we're using a functional language, we don't replace a variable
              ;; create a new def with the old word replaced instead, and then use that
              words-without-close (assoc words
                                         pos-of-closing-word
                                         closing-word-without-tilde)

              ;; now we get the the next word to add to our region
              ;; ie ["~sllehs" "aes" "slles" "ehs"] => "slles"
              next-word (nth words (inc pos-of-closing-word))

              ;; if it was already in a backspaced region, then we remove the starting ~
              ;; this accounts for regions like "hello wonderful ~world~ hi I am a ~long line~"
              ;; where there have been previous backspace regions.
              ;; in this case, just removing the opening tilde will combine the two regions, and
              ;; we don't need to change anything else.
              ;; else we leave it as is
              next-word-already-striked-through? (s/starts-with? next-word "~")
              next-word-with-removed-opening-tilde (if next-word-already-striked-through?
                                                     (s/join "" (rest next-word))
                                                     next-word)

              ;; finally, we add the closing ~ thereby adding that word to our backspaced region
              next-word-with-closing-tilde (if (s/ends-with? next-word-with-removed-opening-tilde "~")
                                             next-word-with-removed-opening-tilde
                                             (str next-word-with-removed-opening-tilde "~"))

              ;; and splice in our modification to our most recent vector of words
              words-with-close (assoc words-without-close
                                      (inc pos-of-closing-word)
                                      (if next-word-already-striked-through?
                                        next-word-with-removed-opening-tilde
                                        next-word-with-closing-tilde))]

          ;; before joining them back into a single string, and reversing it.
          (s/reverse (s/join " " words-with-close)))))))


(defn markdown-input [entry* uid]
  (mli/multi-line-text-input entry* uid markdown-backspace))

(defn markdown-surface [entry* uid title]
  (structure/surface title
                     entry*
                     uid
                     markdown-input
                     mkd/markdown-display))
