import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


class SplittingTest {
    private int[] emptyArray;
    private int[] singleElementArray;
    private int[] balancedArray;
    private int[] unbalancedArray;
    private int[] negativeBalancedArray;
    private int[] oddSumArray;
    private int[] nullArray;

    @BeforeEach
    public void setUp() {
        emptyArray = new int[]{};
        singleElementArray = new int[]{1};
        balancedArray = new int[]{1, 1, 1, 2, 1};
        unbalancedArray = new int[]{2, 1, 1, 2, 1};
        negativeBalancedArray = new int[]{1, -1, 1, -1, 1, -1};
        oddSumArray = new int[]{1, 1, 1};
        nullArray = null;
    }

    @Test
    public void testEmptyArray() {
        assertFalse(Splitting.canBalance(emptyArray));
    }

    @Test
    public void testSingleElementArray() {
        assertFalse(Splitting.canBalance(singleElementArray));
    }

    @Test
    public void testBalancedArray() {
        assertTrue(Splitting.canBalance(balancedArray));
    }

    @Test
    public void testUnbalancedArray() {
        assertFalse(Splitting.canBalance(unbalancedArray));
    }

    @Test
    public void testNegativeBalancedArray() {
        assertTrue(Splitting.canBalance(negativeBalancedArray));
    }

    @Test
    public void testOddSumArray() {
        assertFalse(Splitting.canBalance(oddSumArray));
    }

    @Test
    public void testNullArray() {
        assertFalse(Splitting.canBalance(nullArray));
    }

}