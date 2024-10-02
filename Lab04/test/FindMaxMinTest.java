import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;


class FindMaxMinTest {

    @Test
    public void testEmptyList() {
        List<Float> emptyList = new ArrayList<>();
        FindMaxMin.findMaxMin(emptyList);
    }

    @Test
    public void testSingleElementList() {
        List<Float> singleElementList = Collections.singletonList(5.0f);
        FindMaxMin.findMaxMin(singleElementList);
    }

    @Test
    public void testMultipleElementList() {
        List<Float> multipleElementList = Arrays.asList(10.0f, 5.0f, 7.5f, 8.3f);
        FindMaxMin.findMaxMin(multipleElementList);
    }

    @Test
    public void testNegativeScores() {
        List<Float> negativeScoresList = Arrays.asList(-5.0f, -3.0f, -7.5f, -2.0f);
        FindMaxMin.findMaxMin(negativeScoresList);
    }

    @Test
    public void testEqualScores() {
        List<Float> equalScoresList = Arrays.asList(8.0f, 8.0f, 8.0f, 8.0f);
        FindMaxMin.findMaxMin(equalScoresList);
    }
}
