import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class RomanTest {

    private RomanNumeral romanNumeral;

    @BeforeEach
    public void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void testSingleCharacter() {
        // Single character tests for valid and invalid Roman numeral
        // Equivalent partition: minimal invalid input
        assertEquals(1, romanNumeral.convert("I"));
        // Equivalent partition: minimal invalid input
        assertThrows(Exception.class, () -> romanNumeral.convert("A"));
    }

    @Test
    public void testBasicNumerals() {
        // Basic numeral tests for valid and invalid characters
        // Equivalent partition: basic valid numeral
        assertEquals(5, romanNumeral.convert("V"));
        // Equivalent partition: basic invalid character
        assertThrows(Exception.class, () -> romanNumeral.convert("Q"));
    }

    @Test
    public void testSimpleAddition() {
        // Simple addition tests for valid and invalid characters
        // Equivalent partition: simple valid addition
        assertEquals(3, romanNumeral.convert("III"));
        // Equivalent partition: valid characters followed by invalid character
        assertThrows(Exception.class, () -> romanNumeral.convert("IIIA"));
    }

    @Test
    public void testSubtractiveNotation() {
        // Subtractive notation tests for valid and invalid sequences
        // Equivalent partition: valid subtractive notation
        assertEquals(4, romanNumeral.convert("IV"));
        // Equivalent partition: invalid subtractive combination
        assertThrows(Exception.class, () -> romanNumeral.convert("IC"));
    }

    @Test
    public void testMixedAdditionAndSubtraction() {
        // Mixed addition and subtraction tests for valid and invalid sequences
        // Equivalent partition: mixed valid notation
        assertEquals(14, romanNumeral.convert("XIV"));
        // Equivalent partition: valid notation followed by invalid repetition
        assertThrows(Exception.class, () -> romanNumeral.convert("XIVV"));
    }

    @Test
    public void testLargeNumbers() {
        // Large numbers tests for valid and invalid sequences
        // Equivalent partition: large valid number
        assertEquals(2018, romanNumeral.convert("MMXVIII"));
        // Equivalent partition: invalid large number combination
        assertThrows(Exception.class, () -> romanNumeral.convert("MMXXM"));
    }

    @Test
    public void testSequentialSubtraction() {
        // Sequential subtraction tests for valid and invalid sequences
        // Equivalent partition: complex valid subtractive notation
        assertEquals(49, romanNumeral.convert("XLIX"));
        // Equivalent partition: invalid sequential repetition
        assertThrows(Exception.class, () -> romanNumeral.convert("XXXX"));
    }

    @Test
    public void testSequentialAddition() {
        // Sequential addition tests for valid and invalid sequences
        // Equivalent partition: complex valid additive notation
        assertEquals(80, romanNumeral.convert("LXXX"));
        // Equivalent partition: invalid sequential repetition
        assertThrows(Exception.class, () -> romanNumeral.convert("LL"));
    }

    @Test
    public void testCombinationOfLargeAndSmallNumerals() {
        // Combination of large and small numerals tests for valid and invalid sequences
        // Equivalent partition: valid complex notation
        assertEquals(1994, romanNumeral.convert("MCMXCIV"));
        // Equivalent partition: invalid complex combination
        assertThrows(Exception.class, () -> romanNumeral.convert("xxxx"));
    }

    @Test
    public void testEmptyString() {
        // Empty string and null input tests for handling special cases
        // Equivalent partition: minimal edge case
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.convert(""));
        // Equivalent partition: null input edge case
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.convert(null));
    }


}
