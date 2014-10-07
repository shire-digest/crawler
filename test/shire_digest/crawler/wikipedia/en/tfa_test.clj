(ns shire-digest.crawler.wikipedia.en.tfa-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [shire-digest.crawler.wikipedia.en.tfa :refer :all]))


(defn- read-page [file-name]
  (let [file-path (str "tests/wikipedia/en/tfa/" file-name)]
    (-> file-path io/resource io/file slurp)))

(deftest test-tfa-parser
  (testing "Parse page without figure."
    (let [page-content (read-page "no_figure.html")
          post (first (parse-tfa page-content))]
      (is (= (:link post) "http://en.wikipedia.org/wiki/Marquee_Moon"))
      (is (= (:title post) "Marquee Moon"))
      (is (= (:author post) "Wikipedia"))
      (is (:summary post))
      (is (:date post))))
  
  (testing "Parse page with figure."
    (let [page-content (read-page "figure.html")
          post (first (parse-tfa page-content))]
      (is (= (:link post) "http://en.wikipedia.org/wiki/Mascarene_martin"))
      (is (= (:title post) "Mascarene martin"))
      (is (= (:author post) "Wikipedia"))
      (is (:summary post))
      (is (:date post)))))
