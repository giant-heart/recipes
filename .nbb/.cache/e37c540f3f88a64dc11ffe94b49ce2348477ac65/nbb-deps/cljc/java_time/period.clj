(ns cljc.java-time.period (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness]) (:import [java.time Period]))
(def zero java.time.Period/ZERO)
(clojure.core/defn get-months {:arglists (quote (["java.time.Period"]))} (^java.lang.Integer [^java.time.Period this12932] (.getMonths this12932)))
(clojure.core/defn of-weeks {:arglists (quote (["int"]))} (^java.time.Period [^java.lang.Integer int12933] (java.time.Period/ofWeeks int12933)))
(clojure.core/defn of-days {:arglists (quote (["int"]))} (^java.time.Period [^java.lang.Integer int12934] (java.time.Period/ofDays int12934)))
(clojure.core/defn is-negative {:arglists (quote (["java.time.Period"]))} (^java.lang.Boolean [^java.time.Period this12935] (.isNegative this12935)))
(clojure.core/defn of {:arglists (quote (["int" "int" "int"]))} (^java.time.Period [^java.lang.Integer int12936 ^java.lang.Integer int12937 ^java.lang.Integer int12938] (java.time.Period/of int12936 int12937 int12938)))
(clojure.core/defn is-zero {:arglists (quote (["java.time.Period"]))} (^java.lang.Boolean [^java.time.Period this12939] (.isZero this12939)))
(clojure.core/defn multiplied-by {:arglists (quote (["java.time.Period" "int"]))} (^java.time.Period [^java.time.Period this12940 ^java.lang.Integer int12941] (.multipliedBy this12940 int12941)))
(clojure.core/defn get-units {:arglists (quote (["java.time.Period"]))} (^java.util.List [^java.time.Period this12942] (.getUnits this12942)))
(clojure.core/defn with-days {:arglists (quote (["java.time.Period" "int"]))} (^java.time.Period [^java.time.Period this12943 ^java.lang.Integer int12944] (.withDays this12943 int12944)))
(clojure.core/defn plus {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))} (^java.time.Period [^java.time.Period this12945 ^java.time.temporal.TemporalAmount java-time-temporal-TemporalAmount12946] (.plus this12945 java-time-temporal-TemporalAmount12946)))
(clojure.core/defn of-months {:arglists (quote (["int"]))} (^java.time.Period [^java.lang.Integer int12947] (java.time.Period/ofMonths int12947)))
(clojure.core/defn to-string {:arglists (quote (["java.time.Period"]))} (^java.lang.String [^java.time.Period this12948] (.toString this12948)))
(clojure.core/defn plus-months {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12949 ^long long12950] (.plusMonths this12949 long12950)))
(clojure.core/defn minus-months {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12951 ^long long12952] (.minusMonths this12951 long12952)))
(clojure.core/defn minus {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalAmount"]))} (^java.time.Period [^java.time.Period this12953 ^java.time.temporal.TemporalAmount java-time-temporal-TemporalAmount12954] (.minus this12953 java-time-temporal-TemporalAmount12954)))
(clojure.core/defn add-to {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))} (^java.time.temporal.Temporal [^java.time.Period this12955 ^java.time.temporal.Temporal java-time-temporal-Temporal12956] (.addTo this12955 java-time-temporal-Temporal12956)))
(clojure.core/defn to-total-months {:arglists (quote (["java.time.Period"]))} (^long [^java.time.Period this12957] (.toTotalMonths this12957)))
(clojure.core/defn plus-days {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12958 ^long long12959] (.plusDays this12958 long12959)))
(clojure.core/defn of-years {:arglists (quote (["int"]))} (^java.time.Period [^java.lang.Integer int12960] (java.time.Period/ofYears int12960)))
(clojure.core/defn get-days {:arglists (quote (["java.time.Period"]))} (^java.lang.Integer [^java.time.Period this12961] (.getDays this12961)))
(clojure.core/defn negated {:arglists (quote (["java.time.Period"]))} (^java.time.Period [^java.time.Period this12962] (.negated this12962)))
(clojure.core/defn get-years {:arglists (quote (["java.time.Period"]))} (^java.lang.Integer [^java.time.Period this12963] (.getYears this12963)))
(clojure.core/defn with-years {:arglists (quote (["java.time.Period" "int"]))} (^java.time.Period [^java.time.Period this12964 ^java.lang.Integer int12965] (.withYears this12964 int12965)))
(clojure.core/defn normalized {:arglists (quote (["java.time.Period"]))} (^java.time.Period [^java.time.Period this12966] (.normalized this12966)))
(clojure.core/defn with-months {:arglists (quote (["java.time.Period" "int"]))} (^java.time.Period [^java.time.Period this12967 ^java.lang.Integer int12968] (.withMonths this12967 int12968)))
(clojure.core/defn between {:arglists (quote (["java.time.LocalDate" "java.time.LocalDate"]))} (^java.time.Period [^java.time.LocalDate java-time-LocalDate12969 ^java.time.LocalDate java-time-LocalDate12970] (java.time.Period/between java-time-LocalDate12969 java-time-LocalDate12970)))
(clojure.core/defn from {:arglists (quote (["java.time.temporal.TemporalAmount"]))} (^java.time.Period [^java.time.temporal.TemporalAmount java-time-temporal-TemporalAmount12971] (java.time.Period/from java-time-temporal-TemporalAmount12971)))
(clojure.core/defn minus-years {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12972 ^long long12973] (.minusYears this12972 long12973)))
(clojure.core/defn get-chronology {:arglists (quote (["java.time.Period"]))} (^java.time.chrono.IsoChronology [^java.time.Period this12974] (.getChronology this12974)))
(clojure.core/defn parse {:arglists (quote (["java.lang.CharSequence"]))} (^java.time.Period [^java.lang.CharSequence java-lang-CharSequence12975] (java.time.Period/parse java-lang-CharSequence12975)))
(clojure.core/defn hash-code {:arglists (quote (["java.time.Period"]))} (^java.lang.Integer [^java.time.Period this12976] (.hashCode this12976)))
(clojure.core/defn subtract-from {:arglists (quote (["java.time.Period" "java.time.temporal.Temporal"]))} (^java.time.temporal.Temporal [^java.time.Period this12977 ^java.time.temporal.Temporal java-time-temporal-Temporal12978] (.subtractFrom this12977 java-time-temporal-Temporal12978)))
(clojure.core/defn get {:arglists (quote (["java.time.Period" "java.time.temporal.TemporalUnit"]))} (^long [^java.time.Period this12979 ^java.time.temporal.ChronoUnit java-time-temporal-TemporalUnit12980] (.get this12979 java-time-temporal-TemporalUnit12980)))
(clojure.core/defn equals {:arglists (quote (["java.time.Period" "java.lang.Object"]))} (^java.lang.Boolean [^java.time.Period this12981 ^java.lang.Object java-lang-Object12982] (.equals this12981 java-lang-Object12982)))
(clojure.core/defn plus-years {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12983 ^long long12984] (.plusYears this12983 long12984)))
(clojure.core/defn minus-days {:arglists (quote (["java.time.Period" "long"]))} (^java.time.Period [^java.time.Period this12985 ^long long12986] (.minusDays this12985 long12986)))