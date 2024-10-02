import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // A sorted array - all at once
    @Test
    void sorted() {
        assertTrue(ArrayUtils.isSorted(new int[] {1,2,3,4}));
    }

    // Empty arrays are sorted by definition
    @Test
    void sortedEmpty() {
        assertTrue(ArrayUtils.isSorted(new int[] {}));
    }

    // Arrays of one element are sorted by definition
    @Test
    void sortedOne() {
        assertTrue(ArrayUtils.isSorted(new int[] {1}));
    }

    // A partially sorted array (some elements are in sorted order, but some aren't)
    @Test
    void sortedPartial() {
        assertFalse(ArrayUtils.isSorted(new int[] {1,4,5,2}));
    }

    // A completely unsorted array (no elements are in sorted order)
    @Test
    void sortedNot() {
        assertFalse(ArrayUtils.isSorted(new int[] {4,3,2,1}));
    }

    // An array with duplicate values (may be sorted or not depending on the values chosen)
    @Test
    void sortedDuplicates() {
        assertFalse(ArrayUtils.isSorted(new int[] {4,2,2,1}));
    }
}