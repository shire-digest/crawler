# crawler

[![Build Status](https://travis-ci.org/shire-digest/crawler.svg?branch=master)](https://travis-ci.org/shire-digest/crawler)


## Crawler Protocol

### Create a crawler

```clojure
=> (require '[shire-digest.crawler.echo :as echo])
nil
=> (def echo-crawler (echo/create crawler-options))
```

### Start crawling

```clojure
=> (require '[shire-digest.crawler.core :refer [parse]])
nil
=> (parse echo-crawler link)
[...]
```

## License

Copyright © 2014 hbc

Distributed under the [SMPPL](https://github.com/xhacker/SMPPL/blob/master/SMPPL-Freeware.md) License.
