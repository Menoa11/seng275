import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {
    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

    @Test
    void highTemp() {
        assertFalse(Boundary.isComfortable(21));
    }
    @Test
    void lowTemp() {
        assertFalse(Boundary.isComfortable(4));
    }
    @Test
    void perfectTemp() {
        assertTrue(Boundary.isComfortable(10));
    }
    @Test
    void oneElevator() {
        assertEquals(1, Boundary.elevatorsRequired(5));
    }
    @Test
    void noElevator() {
        assertEquals(0, Boundary.elevatorsRequired(1));
    }
    @Test
    void aboveTwo() {
        assertEquals(2, Boundary.elevatorsRequired(6));
    }
    @ParameterizedTest(name="Number{0}, Letter{1}")
    @CsvSource({"49, F", "59, D", "64, C", "69, C+", "72, B-", "76, B", "79, B+", "84, A-", "89, A", "90, A+"})
    void getGrade(int Number, String Letter) {
        assertEquals(Letter, Boundary.percentageToLetterGrade(Number) );
    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void invalidGrade(int grade) {

        String expectedMessage = "invalidGrade";
        Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> {
            Boundary.percentageToLetterGrade(grade);
        });

    }


}

