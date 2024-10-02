import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

    @Test
    public void testHDModeUpperLeftCorner() {
        assertTrue(Specification.insideDisplayArea(0, 0));
    }

    @Test
    public void testHDModeLowerRightCorner() {
        assertTrue(Specification.insideDisplayArea(1279, 719));
    }

    @Test
    public void testHDModeOutOfBounds() {
        assertFalse(Specification.insideDisplayArea(1280, 720));
    }

    @Test
    public void testHDModeWithinBounds() {
        assertTrue(Specification.insideDisplayArea(640, 360));
    }

    @Test
    public void testHDModeNegativeCoordinates() {
        assertFalse(Specification.insideDisplayArea(-1, -1));
    }

    @Test
    public void testFHDModeUpperLeftCorner() {
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(0, 0));
    }

    @Test
    public void testFHDModeLowerRightCorner() {
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(1919, 1079));
    }

    @Test
    public void testFHDModeOutOfBounds() {
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(1920, 1080));
    }

    @Test
    public void testFHDModeWithinBounds() {
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(960, 540));
    }

    @Test
    public void testFHDModeNegativeCoordinates() {
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(-1, -1));
    }

    //Tests for the second method:



    @Test
    public void testValidMessages() {
        assertTrue(Specification.messageIsValid("ABC123", false));
        assertTrue(Specification.messageIsValid("A B-C", false));
        assertTrue(Specification.messageIsValid("123ABC", false));
        assertTrue(Specification.messageIsValid("A-BC", false));
        assertTrue(Specification.messageIsValid("AB-12", false));
    }

    @Test
    public void testValidMotorcycleMessages() {
        assertTrue(Specification.messageIsValid("ABC12", true));
        assertTrue(Specification.messageIsValid("A B", true));
        assertTrue(Specification.messageIsValid("1A-BC", true));
        assertTrue(Specification.messageIsValid("AB 1", true));
    }

    @Test
    public void testInvalidLength() {
        assertFalse(Specification.messageIsValid("A", false));
        assertFalse(Specification.messageIsValid("ABC-DEFGH", false));
        assertFalse(Specification.messageIsValid("A", true));
        assertFalse(Specification.messageIsValid("ABC-DEFG", true));
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(Specification.messageIsValid("ABC@123", false));
        assertFalse(Specification.messageIsValid("A B*C", false));
        assertFalse(Specification.messageIsValid("ABC_123", false));
    }

    @Test
    public void testAllNumbers() {
        assertFalse(Specification.messageIsValid("123456", false));
        assertFalse(Specification.messageIsValid("12345", true));
    }

    @Test
    public void testLeadingTrailingSpacesOrHyphens() {
        assertFalse(Specification.messageIsValid(" ABC", false));
        assertFalse(Specification.messageIsValid("ABC ", false));
        assertFalse(Specification.messageIsValid("-ABC", false));
        assertFalse(Specification.messageIsValid("ABC-", false));
    }

//    @Test
//    public void testNotRightTests() {
//        assertFalse(Specification.messageIsValid("ABCDEFG", false));
//    }
}



