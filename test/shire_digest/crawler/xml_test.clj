(ns shire-digest.crawler.xml-test
  (:require [clojure.test :refer :all]
            [shire-digest.crawler.xml :refer :all]))


(deftest test-clean
  (testing "Cleanup unreferenced entities."
    (let [content "&trade;&trade&reg;reg;"
          expected-content "&#8482;&trade&#174;reg;"]
      (is (= expected-content (clean content))))))
