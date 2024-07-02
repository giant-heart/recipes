(ns cljc.java-time.period (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness] [goog.object] [java.time :refer [Period]]))
(def zero (goog.object/get java.time.Period "ZERO"))
(clojure.core/defn get-months {:arglists (quote (["java.time.Period"]))} (^int [^js/JSJoda.Period this12987] (.months this12987)))
(clojure.core/defn of-weeks {:arglists (quote (["int"]))} (^js/JSJoda.Period [^int int12988] (js-invoke java.time.Period "ofWeeks" int12988)))
(clojure.core/defn of-days {:arglists (quote (["int"]))} (^js/JSJoda.Period [^int int12989] (js-invoke java.time.Period "ofDays" int12989)))
(clojure.core/defn is-negative {:arglists (quote (["java.time.Period"]))} (^boolean [^js/JSJoda.Period this12990] (.isNegative this12990)))
(clojure.core/defn of {:arglists (quote (["int" "int" "int"]))} (^js/JSJoda.Period [^int int12991 ^int int12992 ^int int12993] (js-invoke java.time.Period "of" int12991 int12992 int12993)))
(clojure.core/defn is-zero {:arglists (quote (["java.time.Period"]))} (^boolean [^js/JSJoda.Period this12994] (.isZero this12994)))
(clojure.core/defn multiplied-by {:arglists (quote (["java.time.Period" "int"]))} (^js/JSJoda.Period [^js/JSJoda.Period this12995 ^int int12996] (.multipliedBy this12995 int12996)))
(clojure.core/defn get-units {:arglists (quote (["java.time.Period"]))} (^java.util.List [^js/JSJoda.Period this12997] (.units this12997)))
(clojure.core/defn with-days {:arglists (quote (["java.time.Period" "int"]))} (^js/JSJoda.Period [^js/JSJoda.Period this12998 ^int int12999] (.withDays this12998 int12999)))
(clojure.core/defn plus {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13000 ^js/JSJoda.TemporalAmount java-time-temporal-TemporalAmount13001] (.plus this13000 java-time-temporal-TemporalAmount13001)))
(clojure.core/defn of-months {:arglists (quote (["int"]))} (^js/JSJoda.Period [^int int13002] (js-invoke java.time.Period "ofMonths" int13002)))
(clojure.core/defn to-string {:arglists (quote (["java.time.Period"]))} (^java.lang.String [^js/JSJoda.Period this13003] (.toString this13003)))
(clojure.core/defn plus-months {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13004 ^long long13005] (.plusMonths this13004 long13005)))
(clojure.core/defn minus-months {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13006 ^long long13007] (.minusMonths this13006 long13007)))
(clojure.core/defn minus {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13008 ^js/JSJoda.TemporalAmount java-time-temporal-TemporalAmount13009] (.minus this13008 java-time-temporal-TemporalAmount13009)))
(clojure.core/defn add-to {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))} (^js/JSJoda.Temporal [^js/JSJoda.Period this13010 ^js/JSJoda.Temporal java-time-temporal-Temporal13011] (.addTo this13010 java-time-temporal-Temporal13011)))
(clojure.core/defn to-total-months {:arglists (quote (["java.time.Period"]))} (^long [^js/JSJoda.Period this13012] (.toTotalMonths this13012)))
(clojure.core/defn plus-days {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13013 ^long long13014] (.plusDays this13013 long13014)))
(clojure.core/defn of-years {:arglists (quote (["int"]))} (^js/JSJoda.Period [^int int13015] (js-invoke java.time.Period "ofYears" int13015)))
(clojure.core/defn get-days {:arglists (quote (["java.time.Period"]))} (^int [^js/JSJoda.Period this13016] (.days this13016)))
(clojure.core/defn negated {:arglists (quote (["java.time.Period"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13017] (.negated this13017)))
(clojure.core/defn get-years {:arglists (quote (["java.time.Period"]))} (^int [^js/JSJoda.Period this13018] (.years this13018)))
(clojure.core/defn with-years {:arglists (quote (["java.time.Period" "int"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13019 ^int int13020] (.withYears this13019 int13020)))
(clojure.core/defn normalized {:arglists (quote (["java.time.Period"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13021] (.normalized this13021)))
(clojure.core/defn with-months {:arglists (quote (["java.time.Period" "int"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13022 ^int int13023] (.withMonths this13022 int13023)))
(clojure.core/defn between {:arglists (quote (["java.time.LocalDate" "java.time.LocalDate"]))} (^js/JSJoda.Period [^js/JSJoda.LocalDate java-time-LocalDate13024 ^js/JSJoda.LocalDate java-time-LocalDate13025] (js-invoke java.time.Period "between" java-time-LocalDate13024 java-time-LocalDate13025)))
(clojure.core/defn from {:arglists (quote (["java.time.temporal.TemporalAmount"]))} (^js/JSJoda.Period [^js/JSJoda.TemporalAmount java-time-temporal-TemporalAmount13026] (js-invoke java.time.Period "from" java-time-temporal-TemporalAmount13026)))
(clojure.core/defn minus-years {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13027 ^long long13028] (.minusYears this13027 long13028)))
(clojure.core/defn get-chronology {:arglists (quote (["java.time.Period"]))} (^js/JSJoda.IsoChronology [^js/JSJoda.Period this13029] (.chronology this13029)))
(clojure.core/defn parse {:arglists (quote (["java.lang.CharSequence"]))} (^js/JSJoda.Period [^java.lang.CharSequence java-lang-CharSequence13030] (js-invoke java.time.Period "parse" java-lang-CharSequence13030)))
(clojure.core/defn hash-code {:arglists (quote (["java.time.Period"]))} (^int [^js/JSJoda.Period this13031] (.hashCode this13031)))
(clojure.core/defn subtract-from {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))} (^js/JSJoda.Temporal [^js/JSJoda.Period this13032 ^js/JSJoda.Temporal java-time-temporal-Temporal13033] (.subtractFrom this13032 java-time-temporal-Temporal13033)))
(clojure.core/defn get {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalUnit"]))} (^long [^js/JSJoda.Period this13034 ^js/JSJoda.TemporalUnit java-time-temporal-TemporalUnit13035] (.get this13034 java-time-temporal-TemporalUnit13035)))
(clojure.core/defn equals {:arglists (quote (["java.time.Period" "java.lang.Object"]))} (^boolean [^js/JSJoda.Period this13036 ^java.lang.Object java-lang-Object13037] (.equals this13036 java-lang-Object13037)))
(clojure.core/defn plus-years {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13038 ^long long13039] (.plusYears this13038 long13039)))
(clojure.core/defn minus-days {:arglists (quote (["java.time.Period" "long"]))} (^js/JSJoda.Period [^js/JSJoda.Period this13040 ^long long13041] (.minusDays this13040 long13041)))