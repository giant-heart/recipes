(ns cljc.java-time.temporal.temporal-query (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness] [goog.object] [java.time.temporal :refer [TemporalQuery]]))
(clojure.core/defn query-from {:arglists (quote (["java.time.temporal.TemporalQuery" "java.time.temporal.TemporalAccessor"]))} (^java.lang.Object [^js/JSJoda.TemporalQuery this15746 ^js/JSJoda.TemporalAccessor java-time-temporal-TemporalAccessor15747] (.queryFrom this15746 java-time-temporal-TemporalAccessor15747)))