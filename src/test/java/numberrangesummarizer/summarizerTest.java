package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class summarizerTest
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
        // Example Case
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        assertEquals(expectedResult,sum.summarizeCollection(sum.collect(input)));

        //Negative Case
        String negInput = "-19,-17,-15,-14,-13,-5,-1,0,1,3,5,7,8,9";
        String expectedNegResult = "-19, -17, -15--13, -5, -1-1, 3, 5, 7-9";
        assertEquals(expectedNegResult,sum.summarizeCollection(sum.collect(negInput)));
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

        // Test summarize method
        assertEquals("",sum.summarizeCollection(null));
        assertEquals("", sum.summarizeCollection(Collections.emptyList()));
    }
}
