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

## Assumptions

- Input can contain an unsorted list of numbers.
- Input can contain duplicated numbers.
- Input can contain whitespaces.
- Duplicate numbers are removed rather than listing twice in summary (i.e. 1,2,3,1 returns 1-3 rather than 1,1-3).
- Invalid integer inputs are caught and an illegalArgumentException is thrown. Can be altered to rather log an error with the invalid value which will allow program to continue without the invalid value. (Commented code - will also need to change unit test).
- Exceeding Max integer value is caught under an IllegalArgumentException.

## To Run

Source files can be found under <code>src/main/java/numberrangesummarizer</code> and 
<code>src/test/java/numberrangesummarizer</code> for unit tests.

Can be tested by running:<br>
<code>./gradlew build</code><br><br>
Results can be viewed by checking:<br>
<code>build/reports/tests/test/index.html</code>

