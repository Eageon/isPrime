(ns clojure-noob.core
  (:gen-class))


(defn prime?
  "Test a whether an input number is a prime"
  [n]
  (cond
   (== 1 n) false
   (== 2 n) true
   (even? n) false
   :else (->> (range 3 (inc (Math/sqrt n)) 2)
              (filter #(zero? (rem n %)))
              empty?)
  )
)

;(time (prime? 1125899906842679))
;(defn -main
;  "main function to generate java class file"
;  [& args]
;  (let [m-prime? (memoize prime?)]
;    (time (m-prime? 1125899906842679))
;    (time (m-prime? 1125899906842679)))
;  (println "This is a println ")
;)

(let [m-prime? (memoize prime?)]
  (time (m-prime? 1125899906842679))
  (time (m-prime? 1125899906842679)))










