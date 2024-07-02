(ns cljc.java-time.format.date-time-formatter-builder (:refer-clojure :exclude [abs get range format min max next name resolve short]) (:require [cljc.java-time.extn.calendar-awareness]) (:import [java.time.format DateTimeFormatterBuilder]))
(clojure.core/defn to-formatter {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"] ["java.time.format.DateTimeFormatterBuilder" "java.util.Locale"]))} (^java.time.format.DateTimeFormatter [^java.time.format.DateTimeFormatterBuilder this15966] (.toFormatter this15966)) (^java.time.format.DateTimeFormatter [^java.time.format.DateTimeFormatterBuilder this15967 ^java.util.Locale java-util-Locale15968] (.toFormatter this15967 java-util-Locale15968)))
(clojure.core/defn append-pattern {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.lang.String"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15969 ^java.lang.String java-lang-String15970] (.appendPattern this15969 java-lang-String15970)))
(clojure.core/defn append-value {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "int"] ["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "int" "int" "java.time.format.SignStyle"] ["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15971 ^java.time.temporal.TemporalField java-time-temporal-TemporalField15972 ^java.lang.Integer int15973] (.appendValue this15971 java-time-temporal-TemporalField15972 int15973)) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15974 ^java.time.temporal.TemporalField java-time-temporal-TemporalField15975 ^java.lang.Integer int15976 ^java.lang.Integer int15977 ^java.time.format.SignStyle java-time-format-SignStyle15978] (.appendValue this15974 java-time-temporal-TemporalField15975 int15976 int15977 java-time-format-SignStyle15978)) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15979 ^java.time.temporal.TemporalField java-time-temporal-TemporalField15980] (.appendValue this15979 java-time-temporal-TemporalField15980)))
(clojure.core/defn append-instant {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"] ["java.time.format.DateTimeFormatterBuilder" "int"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15981] (.appendInstant this15981)) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15982 ^java.lang.Integer int15983] (.appendInstant this15982 int15983)))
(clojure.core/defn append-literal {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "char"] ["java.time.format.DateTimeFormatterBuilder" "java.lang.String"]))} (^java.time.format.DateTimeFormatterBuilder [this15984 G__15985] (clojure.core/cond (clojure.core/and (clojure.core/instance? java.lang.Character G__15985)) (clojure.core/let [G__15985 ^"java.lang.Character" G__15985] (.appendLiteral ^java.time.format.DateTimeFormatterBuilder this15984 G__15985)) (clojure.core/and (clojure.core/instance? java.lang.String G__15985)) (clojure.core/let [G__15985 ^"java.lang.String" G__15985] (.appendLiteral ^java.time.format.DateTimeFormatterBuilder this15984 G__15985)) :else (throw (java.lang.IllegalArgumentException. "no corresponding java.time method with these args")))))
(clojure.core/defn optional-start {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15986] (.optionalStart this15986)))
(clojure.core/defn append-fraction {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "int" "int" "boolean"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15987 ^java.time.temporal.TemporalField java-time-temporal-TemporalField15988 ^java.lang.Integer int15989 ^java.lang.Integer int15990 ^java.lang.Boolean boolean15991] (.appendFraction this15987 java-time-temporal-TemporalField15988 int15989 int15990 boolean15991)))
(clojure.core/defn append-optional {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.DateTimeFormatter"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15992 ^java.time.format.DateTimeFormatter java-time-format-DateTimeFormatter15993] (.appendOptional this15992 java-time-format-DateTimeFormatter15993)))
(clojure.core/defn optional-end {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15994] (.optionalEnd this15994)))
(clojure.core/defn parse-lenient {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15995] (.parseLenient this15995)))
(clojure.core/defn pad-next {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "int"] ["java.time.format.DateTimeFormatterBuilder" "int" "char"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15996 ^java.lang.Integer int15997] (.padNext this15996 int15997)) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this15998 ^java.lang.Integer int15999 ^java.lang.Character char16000] (.padNext this15998 int15999 char16000)))
(clojure.core/defn append-chronology-id {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16001] (.appendChronologyId this16001)))
(clojure.core/defn append-zone-or-offset-id {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16002] (.appendZoneOrOffsetId this16002)))
(clojure.core/defn parse-case-sensitive {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16003] (.parseCaseSensitive this16003)))
(clojure.core/defn parse-strict {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16004] (.parseStrict this16004)))
(clojure.core/defn append-chronology-text {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.TextStyle"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16005 ^java.time.format.TextStyle java-time-format-TextStyle16006] (.appendChronologyText this16005 java-time-format-TextStyle16006)))
(clojure.core/defn append-offset-id {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16007] (.appendOffsetId this16007)))
(clojure.core/defn append-zone-region-id {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16008] (.appendZoneRegionId this16008)))
(clojure.core/defn parse-defaulting {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "long"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16009 ^java.time.temporal.TemporalField java-time-temporal-TemporalField16010 ^long long16011] (.parseDefaulting this16009 java-time-temporal-TemporalField16010 long16011)))
(clojure.core/defn append-zone-id {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16012] (.appendZoneId this16012)))
(clojure.core/defn get-localized-date-time-pattern {:arglists (quote (["java.time.format.FormatStyle" "java.time.format.FormatStyle" "java.time.chrono.Chronology" "java.util.Locale"]))} (^java.lang.String [^java.time.format.FormatStyle java-time-format-FormatStyle16013 ^java.time.format.FormatStyle java-time-format-FormatStyle16014 ^java.time.chrono.Chronology java-time-chrono-Chronology16015 ^java.util.Locale java-util-Locale16016] (java.time.format.DateTimeFormatterBuilder/getLocalizedDateTimePattern java-time-format-FormatStyle16013 java-time-format-FormatStyle16014 java-time-chrono-Chronology16015 java-util-Locale16016)))
(clojure.core/defn parse-case-insensitive {:arglists (quote (["java.time.format.DateTimeFormatterBuilder"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16017] (.parseCaseInsensitive this16017)))
(clojure.core/defn append-localized-offset {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.TextStyle"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16018 ^java.time.format.TextStyle java-time-format-TextStyle16019] (.appendLocalizedOffset this16018 java-time-format-TextStyle16019)))
(clojure.core/defn append {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.DateTimeFormatter"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16020 ^java.time.format.DateTimeFormatter java-time-format-DateTimeFormatter16021] (.append this16020 java-time-format-DateTimeFormatter16021)))
(clojure.core/defn append-text {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "java.time.format.TextStyle"] ["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField"] ["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "java.util.Map"]))} (^java.time.format.DateTimeFormatterBuilder [this16022 G__16023 G__16024] (clojure.core/cond (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField G__16023) (clojure.core/instance? java.time.format.TextStyle G__16024)) (clojure.core/let [G__16023 ^"java.time.temporal.TemporalField" G__16023 G__16024 ^"java.time.format.TextStyle" G__16024] (.appendText ^java.time.format.DateTimeFormatterBuilder this16022 G__16023 G__16024)) (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField G__16023) (clojure.core/instance? java.util.Map G__16024)) (clojure.core/let [G__16023 ^"java.time.temporal.TemporalField" G__16023 G__16024 ^"java.util.Map" G__16024] (.appendText ^java.time.format.DateTimeFormatterBuilder this16022 G__16023 G__16024)) :else (throw (java.lang.IllegalArgumentException. "no corresponding java.time method with these args")))) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16025 ^java.time.temporal.TemporalField java-time-temporal-TemporalField16026] (.appendText this16025 java-time-temporal-TemporalField16026)))
(clojure.core/defn append-localized {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.FormatStyle" "java.time.format.FormatStyle"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16027 ^java.time.format.FormatStyle java-time-format-FormatStyle16028 ^java.time.format.FormatStyle java-time-format-FormatStyle16029] (.appendLocalized this16027 java-time-format-FormatStyle16028 java-time-format-FormatStyle16029)))
(clojure.core/defn append-offset {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.lang.String" "java.lang.String"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16030 ^java.lang.String java-lang-String16031 ^java.lang.String java-lang-String16032] (.appendOffset this16030 java-lang-String16031 java-lang-String16032)))
(clojure.core/defn append-value-reduced {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "int" "int" "int"] ["java.time.format.DateTimeFormatterBuilder" "java.time.temporal.TemporalField" "int" "int" "java.time.chrono.ChronoLocalDate"]))} (^java.time.format.DateTimeFormatterBuilder [this16033 G__16034 G__16035 G__16036 G__16037] (clojure.core/cond (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField G__16034) (clojure.core/instance? java.lang.Number G__16035) (clojure.core/instance? java.lang.Number G__16036) (clojure.core/instance? java.lang.Number G__16037)) (clojure.core/let [G__16034 ^"java.time.temporal.TemporalField" G__16034 G__16035 (clojure.core/int G__16035) G__16036 (clojure.core/int G__16036) G__16037 (clojure.core/int G__16037)] (.appendValueReduced ^java.time.format.DateTimeFormatterBuilder this16033 G__16034 G__16035 G__16036 G__16037)) (clojure.core/and (clojure.core/instance? java.time.temporal.TemporalField G__16034) (clojure.core/instance? java.lang.Number G__16035) (clojure.core/instance? java.lang.Number G__16036) (clojure.core/instance? java.time.chrono.ChronoLocalDate G__16037)) (clojure.core/let [G__16034 ^"java.time.temporal.TemporalField" G__16034 G__16035 (clojure.core/int G__16035) G__16036 (clojure.core/int G__16036) G__16037 ^"java.time.chrono.ChronoLocalDate" G__16037] (.appendValueReduced ^java.time.format.DateTimeFormatterBuilder this16033 G__16034 G__16035 G__16036 G__16037)) :else (throw (java.lang.IllegalArgumentException. "no corresponding java.time method with these args")))))
(clojure.core/defn append-zone-text {:arglists (quote (["java.time.format.DateTimeFormatterBuilder" "java.time.format.TextStyle"] ["java.time.format.DateTimeFormatterBuilder" "java.time.format.TextStyle" "java.util.Set"]))} (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16038 ^java.time.format.TextStyle java-time-format-TextStyle16039] (.appendZoneText this16038 java-time-format-TextStyle16039)) (^java.time.format.DateTimeFormatterBuilder [^java.time.format.DateTimeFormatterBuilder this16040 ^java.time.format.TextStyle java-time-format-TextStyle16041 ^java.util.Set java-util-Set16042] (.appendZoneText this16040 java-time-format-TextStyle16041 java-util-Set16042)))