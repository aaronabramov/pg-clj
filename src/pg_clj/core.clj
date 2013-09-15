(ns pg-clj.core)

(defn -main [query-name]
  (let [query (slurp (str "./sql/" query-name ".sql"))]
    (println query)))
