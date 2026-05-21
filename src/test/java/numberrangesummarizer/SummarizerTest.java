package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SummarizerTest
{
    private Summarizer sum;

    @BeforeEach
    void setUp()
    {
        sum = new Summarizer();
    }

    @Test
    @DisplayName("Correctly collect and summarize the given example input and negative integer input")
    public void testBaseCase()
    {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> inputCollection = List.of(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";

        // Test Collect method
        assertEquals(inputCollection,sum.collect(input));

        // Test SummarizeCollection method
        assertEquals(expectedResult,sum.summarizeCollection(inputCollection));
    }

    @Test
    @DisplayName("Correctly collect and summarize a negative integer input")
    public void testNegativeCase()
    {
        String negInput = "-19,-17,-15,-14,-13,-5,-1,0,1,3,5,7,8,9";
        Collection<Integer> inputCollection = List.of(-19,-17,-15,-14,-13,-5,-1,0,1,3,5,7,8,9);
        String expectedNegResult = "-19, -17, -15--13, -5, -1-1, 3, 5, 7-9";

        // Test Collect method
        assertEquals(inputCollection,sum.collect(negInput));

        // Test SummarizeCollection method
        assertEquals(expectedNegResult,sum.summarizeCollection(inputCollection));
    }

    @Test
    @DisplayName("Handle single element input")
    public void testSingleElement()
    {
        Collection<Integer> input = List.of(15);

        // Test Collect method
        assertEquals(input,sum.collect("15"));

        // Test SummarizeCollection method
        assertEquals("15",sum.summarizeCollection(input));
    }

    @Test
    @DisplayName("Handle empty and null Strings and collections")
    public void testEmptyCase()
    {
        // Test Collect method
        assertTrue(sum.collect(null).isEmpty());
        assertTrue(sum.collect("").isEmpty());
        assertTrue(sum.collect(",").isEmpty());
        assertTrue(sum.collect("     ").isEmpty());

        // Test SummarizeCollection method
        assertEquals("",sum.summarizeCollection(null));
        assertEquals("",sum.summarizeCollection(Collections.emptyList()));
    }

    @Test
    @DisplayName("Handle an unsorted input string")
    public void testUnsortedCase()
    {
        String unsorted = "6,13,1,23,22,31,7,3,21,24,12,8,14,15";
        Collection<Integer> unsortedCollection = List.of(6,13,1,23,22,31,7,3,21,24,12,8,14,15);
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";

        // Test Collect method
        assertEquals(unsortedCollection,sum.collect(unsorted));
        // Test SummarizeCollection method
        assertEquals(expectedResult,sum.summarizeCollection(unsortedCollection));
    }

    @Test
    @DisplayName("Handle a string with white spaces both as elements and part of elements")
    public void testWhiteSpacesCase()
    {
        String input = "  1, 3,6       ,7,    ,    9 ,10, 11 ,12";
        Collection<Integer> inputCollection = List.of(1,3,6,7,9,10,11,12);
        String expectedResult = "1, 3, 6-7, 9-12";

        // Test Collect method
        assertEquals(inputCollection,sum.collect(input));
        // Test SummarizeCollection method
        assertEquals(expectedResult,sum.summarizeCollection(inputCollection));
    }

    @Test
    @DisplayName("Handle strings with duplicated numbers")
    public void testDuplicatedCase()
    {
        String input = "10,15,16,16,16,18,20,21,22,22,23,25,25";
        Collection<Integer> inputCollection = List.of(10,15,16,16,16,18,20,21,22,22,23,25,25);
        String expectedResult = "10, 15-16, 18, 20-23, 25";

        // Test Collect method
        assertEquals(inputCollection,sum.collect(input));
        // Test SummarizeCollection method
        assertEquals(expectedResult,sum.summarizeCollection(inputCollection));
    }

    @ParameterizedTest
    @ValueSource(strings =
            {
                    "2,5,six,7,10,11",
                    "7,8.5,9",
                    "99999999999"
            })
    @DisplayName("Handle strings with invalid integers/elements")
    public void testInvalidCase(String input)
    {
        assertThrows(IllegalArgumentException.class, () -> sum.collect(input));
    }

}
