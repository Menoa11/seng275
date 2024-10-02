import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


class CollectionUtilsTest {

    private List<Integer> emptyList;
    private List<Integer> list123;
    private List<Integer> list456;
    private List<Integer> list234;
    private List<Integer> list12;

    @BeforeEach
    public void setUp() {
        emptyList = Collections.emptyList();
        list123 = Arrays.asList(1, 2, 3);
        list456 = Arrays.asList(4, 5, 6);
        list234 = Arrays.asList(2, 3, 4);
        list12 = Arrays.asList(1, 2);
    }

    @Test
    public void testBothCollectionsEmpty() {
        assertFalse(CollectionUtils.containsAny(emptyList, emptyList));
    }

    @Test
    public void testFirstCollectionEmpty() {
        assertFalse(CollectionUtils.containsAny(emptyList, list123));
    }

    @Test
    public void testSecondCollectionEmpty() {
        assertFalse(CollectionUtils.containsAny(list123, emptyList));
    }

    @Test
    public void testNoCommonElements() {
        assertFalse(CollectionUtils.containsAny(list123, list456));
    }

    @Test
    public void testCommonElementsColl1Smaller() {
        assertTrue(CollectionUtils.containsAny(list12, list234));
    }

    @Test
    public void testCommonElementsColl2Smaller() {
        assertTrue(CollectionUtils.containsAny(list234, list12));
    }

    @Test
    public void testEqualSizedCollectionsWithCommonElements() {
        assertTrue(CollectionUtils.containsAny(list123, list234));
    }

    @Test
    public void testEqualSizedCollectionsNoCommonElements() {
        assertFalse(CollectionUtils.containsAny(list123, list456));
    }

    @Test
    public void testContainsAnyWithNull() {
        assertThrows(NullPointerException.class, () -> CollectionUtils.containsAny(list123, null));
    }
}