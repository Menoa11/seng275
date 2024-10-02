import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class ComplexAddTest {
    private ComplexAdd complexAdd;

    @BeforeEach
    public void setUp() {
        complexAdd = new ComplexAdd();
    }

    @Test
    public void testComplexAdd_LessThan2() {
        int result = complexAdd.ComplexAdd(1, 3);
        assertEquals(-4, result);
    }

    @Test
    public void testComplexAdd_GreaterThanOrEqualTo2() {
        int result = complexAdd.ComplexAdd(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testComplexAdd_EqualTo2() {
        int result = complexAdd.ComplexAdd(2, 2);
        assertEquals(4, result);
    }

    // During my first mutation testing run all the lines were covered and the branch testing
    // came out to be 100% as well. Strangely enough all the mutations were failing when the ComplexAdd method was
    // changed. I will be adding some more tests just in case im missing something and see
    // if I receive the same outcome

    @Test
    public void testComplexALessThan2_PositiveB() {
        int result = complexAdd.ComplexAdd(1, 3);
        assertEquals(-4, result);
    }

    @Test
    public void testComplexALessThan2_ZeroB() {
        int result = complexAdd.ComplexAdd(1, 0);
        assertEquals(-1, result);
    }

    @Test
    public void testComplexAGreaterThan2_PositiveB() {
        int result = complexAdd.ComplexAdd(3, 3);
        assertEquals(6, result);
    }

    @Test
    public void testComplexAGreaterThan2_NegativeB() {
        int result = complexAdd.ComplexAdd(3, -3);
        assertEquals(0, result);
    }

    @Test
    public void testComplexAGreaterThan2_ZeroB() {
        int result = complexAdd.ComplexAdd(3, 0);
        assertEquals(3, result);
    }

    @Test
    public void testComplexAEqualTo2_PositiveB() {
        int result = complexAdd.ComplexAdd(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testComplexAEqualTo2_NegativeB() {
        int result = complexAdd.ComplexAdd(2, -3);
        assertEquals(-1, result);
    }

    @Test
    public void testComplexAEqualTo2_ZeroB() {
        int result = complexAdd.ComplexAdd(2, 0);
        assertEquals(2, result);
    }

    @Test
    public void testComplexBothZero() {
        int result = complexAdd.ComplexAdd(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testComplexAZero_PositiveB() {
        int result = complexAdd.ComplexAdd(0, 3);
        assertEquals(-3, result);
    }

    @Test
    public void testComplexAZero_NegativeB() {
        int result = complexAdd.ComplexAdd(0, -3);
        assertEquals(3, result);
    }

    // After adding a bunch of new tests the mutations are still all getting caught
    // by my unit tests (the tests are failing when the mehtod is altered). I would have
    // thought that one of my new tests would have failed to see a mutation but that just
    // was not the case.

    // This is the final test suite which results to 100% of mutations being caught.

    // After testing all my unit tests for this lab with coverage i can say that they
    // all have 100% line coverage and branch coverage
}
