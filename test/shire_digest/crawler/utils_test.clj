(ns shire-digest.crawler.utils-test
  (:require [clojure.test :refer :all]
            [shire-digest.crawler.utils :refer :all]))

(deftest test-today
  (testing "Get today's date."
    (is (today))))
