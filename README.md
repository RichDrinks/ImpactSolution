# Number Range Summarizer

A robust, tested implementation of the <code>NumberRangeSummarizer</code> interface built with Gradle(Kotlin DSL).
Parses a comma-delimited string of integers, sorting, deduplicating and summarizing them by reducing consecutive numbers
into a range.  

## Handling

- unsorted list
- duplicated numbers
- invalid numbers
- whitespaces
- empty/null cases

## To Run

Source files can be found under <code>src/main/java/numberrangesummarizer</code> and 
<code>src/test/java/numberrangesummarizer</code> for unit tests.

Can be tested by running:<br>
<code>./gradlew build</code><br><br>
Results can be viewed by checking:<br>
<code>build/reports/tests/test/index.html</code>

