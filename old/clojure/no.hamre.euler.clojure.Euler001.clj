(println "svaret: "
  (reduce + (distinct
    (concat
      (filter #(= (mod % 5) 0) (range 1 1000) )
      (fiTlter #(= (mod % 3) 0) (range 1 1000) )))))