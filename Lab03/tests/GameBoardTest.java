import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    GameBoard board = new GameBoard();

    @Test
    void testGoodWeather() {
        int[][] goodWeatherTests = {
                {0, 0}, {5, 5}, {3, 2}, {1, 4}, {4, 1}
        };
        for (int[] coords : goodWeatherTests) {
            assertTrue(board.isWithinBoard(coords[0], coords[1]), "Failed for point (" + coords[0] + ", " + coords[1] + ")");
        }
    }

    @Test
    void testBadWeather() {
        int[][] badWeatherTests = {
                {6, 6}, {-1, 0}, {0, -1}, {7, 3}
        };
        for (int[] coords : badWeatherTests) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                board.isWithinBoard(coords[0], coords[1]);
            });
            assertEquals("Coordinates (" + coords[0] + ", " + coords[1] + ") are outside the board.", exception.getMessage());
        }
    }

    // Left boundary tests
    @Test
    void testLeftBoundaryOn() {
        assertTrue(board.isWithinBoard(0, 0));
    }

    @Test
    void testLeftBoundaryOff() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.isWithinBoard(-1, 0);
        });
        assertEquals("Coordinates (-1, 0) are outside the board.", exception.getMessage());
    }

    // Right boundary tests
    @Test
    void testRightBoundaryOn() {
        assertTrue(board.isWithinBoard(5, 0));
    }

    @Test
    void testRightBoundaryOff() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.isWithinBoard(6, 0);
        });
        assertEquals("Coordinates (6, 0) are outside the board.", exception.getMessage());
    }

    // Top boundary tests
    @Test
    void testTopBoundaryOn() {
        assertTrue(board.isWithinBoard(0, 0));
    }

    @Test
    void testTopBoundaryOff() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.isWithinBoard(0, -1);
        });
        assertEquals("Coordinates (0, -1) are outside the board.", exception.getMessage());
    }

    // Bottom boundary tests
    @Test
    void testBottomBoundaryOn() {
        assertTrue(board.isWithinBoard(0, 5));
    }

    @Test
    void testBottomBoundaryOff() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.isWithinBoard(0, 6);
        });
        assertEquals("Coordinates (0, 6) are outside the board.", exception.getMessage());
    }

    @Test
    void testBottomRightBoundaryOn() {
        assertTrue(board.isWithinBoard(5, 5));
    }

    @Test
    void testBottomRightBoundaryOff() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.isWithinBoard(5, 6);
        });
        assertEquals("Coordinates (5, 6) are outside the board.", exception.getMessage());
    }


}
