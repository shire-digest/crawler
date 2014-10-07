(ns shire-digest.crawler.utils
  "Utilities."
  (:require [clj-time.format :as time-format]
            [clj-time.local :as time-local]))


(def date-formatter (time-format/formatter "yyyy-MM-dd"))

(defn today
  "Get today's date."
  []
  (time-format/unparse date-formatter (time-local/local-now)))
