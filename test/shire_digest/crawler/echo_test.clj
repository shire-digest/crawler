(ns shire-digest.crawler.echo-test
  (:require [clojure.test :refer :all]
            [shire-digest.crawler.core :refer [parse]]
            [shire-digest.crawler.echo :refer :all]))

(deftest test-echo-crawler
  (testing "EchoCrawler parse."
    (let [test-link "http://example.com"
          post (first (parse echo-crawler test-link))]
      (is (= (:link post) test-link))
      (is (= (:title post) test-link)))))
