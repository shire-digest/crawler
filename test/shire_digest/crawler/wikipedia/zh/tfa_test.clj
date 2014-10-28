(ns shire-digest.crawler.wikipedia.zh.tfa-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [shire-digest.crawler.wikipedia.zh.tfa :refer :all]))


(defn- read-page [file-name]
  (let [file-path (str "tests/wikipedia/zh/tfa/" file-name)]
    (-> file-path io/resource io/file slurp)))


(deftest test-tfa-parser
  (testing "Parse page with figure."
    (let [page-content (read-page "figure.html")
          post (first (parse-tfa page-content))]
      (is (= (:link post) "http://zh.wikipedia.org/wiki/%E4%B9%94%E6%B2%BB%C2%B7%E5%B7%B4%E9%A1%BF%E6%8E%8C%E6%8E%B4%E4%BA%8B%E4%BB%B6"))
      (is (= (:title post) "乔治·巴顿掌掴事件"))
      (is (= (:author post) "Wikipedia"))
      (is (:summary post))
      (is (:date post)))))
