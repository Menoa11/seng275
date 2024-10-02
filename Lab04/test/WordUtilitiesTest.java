import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {
    @Test
    public void testSwapCase_nullInput() {

        String input = null;
        String result = WordUtilities.swapCase(input);
        assertNull(result);
    }

    @Test
    public void testSwapCase_emptyInput() {

        String input = "";
        String result = WordUtilities.swapCase(input);
        assertEquals("", result);
    }

    @Test
    public void testSwapCase_upperCase() {

        String input = "HELLO";
        String result = WordUtilities.swapCase(input);
        assertEquals("hello", result);
    }

    @Test
    public void testSwapCase_lowerCase() {

        String input = "hello";
        String result = WordUtilities.swapCase(input);
        assertEquals("HELLO", result);
    }

    @Test
    public void testSwapCase_titleCase() {

        String input = "Hello";
        String result = WordUtilities.swapCase(input);
        assertEquals("hELLO", result);
    }

    @Test
    public void testSwapCase_mixedCase() {

        String input = "HeLLo WorLD";
        String result = WordUtilities.swapCase(input);
        assertEquals("hEllO wORld", result);
    }

    @Test
    public void testSwapCase_withWhitespace() {

        String input = "hello world";
        String result = WordUtilities.swapCase(input);
        assertEquals("HELLO WORLD", result);
    }


}