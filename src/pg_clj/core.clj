(ns pg-clj.core
  (:require [clojure.java.jdbc :as j]
            [clojure.string :refer [split trim]]))

(def db "jdbc:postgresql://localhost:5432/pg_clj")

(defn print-query-results [query]
  (println "\033[32mExecuting query:\033[0m")
  (println (str "\033[36m" query "\033[0m"))
  (j/with-connection db
    (j/with-query-results rs [query]
      (doseq [row rs]
        (println row)))))


(defn -main [query-name]
  (let [queries-string (trim (slurp (str "./sql/" query-name ".sql")))
        queries (split queries-string #";")]
    (doseq [query queries]
      (print-query-results query))))
