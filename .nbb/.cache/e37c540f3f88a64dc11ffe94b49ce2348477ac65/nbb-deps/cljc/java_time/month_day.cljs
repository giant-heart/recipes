(ns cljc.java-time.month-day (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness] [goog.object] [java.time :refer [MonthDay]]))
(clojure.core/defn at-year {:arglists (quote (["java.time.MonthDay" "int"]))} (^js/JSJoda.LocalDate [^js/JSJoda.MonthDay this14890 ^int int14891] (.atYear this14890 int14891)))
(clojure.core/defn range {:arglists (quote (["java.time.MonthDay" "java.time.temporal.TemporalField"]))} (^js/JSJoda.ValueRange [^js/JSJoda.MonthDay this14892 ^js/JSJoda.TemporalField java-time-temporal-TemporalField14893] (.range this14892 java-time-temporal-TemporalField14893)))
(clojure.core/defn of {:arglists (quote (["int" "int"] ["java.time.Month" "int"]))} (^js/JSJoda.MonthDay [G__14895 G__14896] (js-invoke java.time.MonthDay "of" G__14895 G__14896)))
(clojure.core/defn with-month {:arglists (quote (["java.time.MonthDay" "int"]))} (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this14897 ^int int14898] (.withMonth this14897 int14898)))
(clojure.core/defn query {:arglists (quote (["java.time.MonthDay" "java.time.temporal.TemporalQuery"]))} (^java.lang.Object [^js/JSJoda.MonthDay this14899 ^js/JSJoda.TemporalQuery java-time-temporal-TemporalQuery14900] (.query this14899 java-time-temporal-TemporalQuery14900)))
(clojure.core/defn to-string {:arglists (quote (["java.time.MonthDay"]))} (^java.lang.String [^js/JSJoda.MonthDay this14901] (.toString this14901)))
(clojure.core/defn is-before {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))} (^boolean [^js/JSJoda.MonthDay this14902 ^js/JSJoda.MonthDay java-time-MonthDay14903] (.isBefore this14902 java-time-MonthDay14903)))
(clojure.core/defn get-long {:arglists (quote (["java.time.MonthDay" "java.time.temporal.TemporalField"]))} (^long [^js/JSJoda.MonthDay this14904 ^js/JSJoda.TemporalField java-time-temporal-TemporalField14905] (.getLong this14904 java-time-temporal-TemporalField14905)))
(clojure.core/defn with-day-of-month {:arglists (quote (["java.time.MonthDay" "int"]))} (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this14906 ^int int14907] (.withDayOfMonth this14906 int14907)))
(clojure.core/defn get-day-of-month {:arglists (quote (["java.time.MonthDay"]))} (^int [^js/JSJoda.MonthDay this14908] (.dayOfMonth this14908)))
(clojure.core/defn from {:arglists (quote (["java.time.temporal.TemporalAccessor"]))} (^js/JSJoda.MonthDay [^js/JSJoda.TemporalAccessor java-time-temporal-TemporalAccessor14909] (js-invoke java.time.MonthDay "from" java-time-temporal-TemporalAccessor14909)))
(clojure.core/defn is-after {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))} (^boolean [^js/JSJoda.MonthDay this14910 ^js/JSJoda.MonthDay java-time-MonthDay14911] (.isAfter this14910 java-time-MonthDay14911)))
(clojure.core/defn is-supported {:arglists (quote (["java.time.MonthDay" "java.time.temporal.TemporalField"]))} (^boolean [^js/JSJoda.MonthDay this14912 ^js/JSJoda.TemporalField java-time-temporal-TemporalField14913] (.isSupported this14912 java-time-temporal-TemporalField14913)))
(clojure.core/defn parse {:arglists (quote (["java.lang.CharSequence" "java.time.format.DateTimeFormatter"] ["java.lang.CharSequence"]))} (^js/JSJoda.MonthDay [^java.lang.CharSequence java-lang-CharSequence14914 ^js/JSJoda.DateTimeFormatter java-time-format-DateTimeFormatter14915] (js-invoke java.time.MonthDay "parse" java-lang-CharSequence14914 java-time-format-DateTimeFormatter14915)) (^js/JSJoda.MonthDay [^java.lang.CharSequence java-lang-CharSequence14916] (js-invoke java.time.MonthDay "parse" java-lang-CharSequence14916)))
(clojure.core/defn is-valid-year {:arglists (quote (["java.time.MonthDay" "int"]))} (^boolean [^js/JSJoda.MonthDay this14917 ^int int14918] (.isValidYear this14917 int14918)))
(clojure.core/defn hash-code {:arglists (quote (["java.time.MonthDay"]))} (^int [^js/JSJoda.MonthDay this14919] (.hashCode this14919)))
(clojure.core/defn adjust-into {:arglists (quote (["java.time.MonthDay" "java.time.temporal.Temporal"]))} (^js/JSJoda.Temporal [^js/JSJoda.MonthDay this14920 ^js/JSJoda.Temporal java-time-temporal-Temporal14921] (.adjustInto this14920 java-time-temporal-Temporal14921)))
(clojure.core/defn with {:arglists (quote (["java.time.MonthDay" "java.time.Month"]))} (^js/JSJoda.MonthDay [^js/JSJoda.MonthDay this14922 ^js/JSJoda.Month java-time-Month14923] (.with this14922 java-time-Month14923)))
(clojure.core/defn now {:arglists (quote (["java.time.ZoneId"] ["java.time.Clock"] []))} (^js/JSJoda.MonthDay [G__14925] (js-invoke java.time.MonthDay "now" G__14925)) (^js/JSJoda.MonthDay [] (js-invoke java.time.MonthDay "now")))
(clojure.core/defn get-month-value {:arglists (quote (["java.time.MonthDay"]))} (^int [^js/JSJoda.MonthDay this14926] (.monthValue this14926)))
(clojure.core/defn compare-to {:arglists (quote (["java.time.MonthDay" "java.time.MonthDay"]))} (^int [^js/JSJoda.MonthDay this14927 ^js/JSJoda.MonthDay java-time-MonthDay14928] (.compareTo this14927 java-time-MonthDay14928)))
(clojure.core/defn get-month {:arglists (quote (["java.time.MonthDay"]))} (^js/JSJoda.Month [^js/JSJoda.MonthDay this14929] (.month this14929)))
(clojure.core/defn get {:arglists (quote (["java.time.MonthDay" "java.time.temporal.TemporalField"]))} (^int [^js/JSJoda.MonthDay this14930 ^js/JSJoda.TemporalField java-time-temporal-TemporalField14931] (.get this14930 java-time-temporal-TemporalField14931)))
(clojure.core/defn equals {:arglists (quote (["java.time.MonthDay" "java.lang.Object"]))} (^boolean [^js/JSJoda.MonthDay this14932 ^java.lang.Object java-lang-Object14933] (.equals this14932 java-lang-Object14933)))
(clojure.core/defn format {:arglists (quote (["java.time.MonthDay" "java.time.format.DateTimeFormatter"]))} (^java.lang.String [^js/JSJoda.MonthDay this14934 ^js/JSJoda.DateTimeFormatter java-time-format-DateTimeFormatter14935] (.format this14934 java-time-format-DateTimeFormatter14935)))