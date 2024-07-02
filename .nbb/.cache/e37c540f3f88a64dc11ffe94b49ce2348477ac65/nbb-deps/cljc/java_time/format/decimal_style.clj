(ns cljc.java-time.format.decimal-style (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness]) (:import [java.time.format DecimalStyle]))
(def standard java.time.format.DecimalStyle/STANDARD)
(clojure.core/defn with-decimal-separator {:arglists (quote (["java.time.format.DecimalStyle" "char"]))} (^java.time.format.DecimalStyle [^java.time.format.DecimalStyle this16144 ^java.lang.Character char16145] (.withDecimalSeparator this16144 char16145)))
(clojure.core/defn of {:arglists (quote (["java.util.Locale"]))} (^java.time.format.DecimalStyle [^java.util.Locale java-util-Locale16146] (java.time.format.DecimalStyle/of java-util-Locale16146)))
(clojure.core/defn with-positive-sign {:arglists (quote (["java.time.format.DecimalStyle" "char"]))} (^java.time.format.DecimalStyle [^java.time.format.DecimalStyle this16147 ^java.lang.Character char16148] (.withPositiveSign this16147 char16148)))
(clojure.core/defn get-decimal-separator {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.Character [^java.time.format.DecimalStyle this16149] (.getDecimalSeparator this16149)))
(clojure.core/defn of-default-locale {:arglists (quote ([]))} (^java.time.format.DecimalStyle [] (java.time.format.DecimalStyle/ofDefaultLocale)))
(clojure.core/defn with-zero-digit {:arglists (quote (["java.time.format.DecimalStyle" "char"]))} (^java.time.format.DecimalStyle [^java.time.format.DecimalStyle this16150 ^java.lang.Character char16151] (.withZeroDigit this16150 char16151)))
(clojure.core/defn to-string {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.String [^java.time.format.DecimalStyle this16152] (.toString this16152)))
(clojure.core/defn get-zero-digit {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.Character [^java.time.format.DecimalStyle this16153] (.getZeroDigit this16153)))
(clojure.core/defn with-negative-sign {:arglists (quote (["java.time.format.DecimalStyle" "char"]))} (^java.time.format.DecimalStyle [^java.time.format.DecimalStyle this16154 ^java.lang.Character char16155] (.withNegativeSign this16154 char16155)))
(clojure.core/defn get-available-locales {:arglists (quote ([]))} (^java.util.Set [] (java.time.format.DecimalStyle/getAvailableLocales)))
(clojure.core/defn get-positive-sign {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.Character [^java.time.format.DecimalStyle this16156] (.getPositiveSign this16156)))
(clojure.core/defn hash-code {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.Integer [^java.time.format.DecimalStyle this16157] (.hashCode this16157)))
(clojure.core/defn get-negative-sign {:arglists (quote (["java.time.format.DecimalStyle"]))} (^java.lang.Character [^java.time.format.DecimalStyle this16158] (.getNegativeSign this16158)))
(clojure.core/defn equals {:arglists (quote (["java.time.format.DecimalStyle" "java.lang.Object"]))} (^java.lang.Boolean [^java.time.format.DecimalStyle this16159 ^java.lang.Object java-lang-Object16160] (.equals this16159 java-lang-Object16160)))