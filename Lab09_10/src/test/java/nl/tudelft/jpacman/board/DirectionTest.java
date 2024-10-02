package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
    private static Direction[] directions;

    @BeforeAll
    public static void setup() {
        directions = Direction.values();
    }

    @Test
    public void testNorthDirection() {
        assertEquals(0, Direction.NORTH.getDeltaX());
        assertEquals(-1, Direction.NORTH.getDeltaY());
    }

    @Test
    public void testSouthDirection() {
        assertEquals(0, Direction.SOUTH.getDeltaX());
        assertEquals(1, Direction.SOUTH.getDeltaY());
    }

    @Test
    public void testWestDirection() {
        assertEquals(-1, Direction.WEST.getDeltaX());
        assertEquals(0, Direction.WEST.getDeltaY());
    }

    @Test
    public void testEastDirection() {
        assertEquals(1, Direction.EAST.getDeltaX());
        assertEquals(0, Direction.EAST.getDeltaY());
    }

    @Test
    public void testAllDirections() {
        for (Direction direction : directions) {
            int deltaX = direction.getDeltaX();
            int deltaY = direction.getDeltaY();

            switch (direction) {
                case NORTH:
                    assertEquals(0, deltaX);
                    assertEquals(-1, deltaY);
                    break;
                case SOUTH:
                    assertEquals(0, deltaX);
                    assertEquals(1, deltaY);
                    break;
                case WEST:
                    assertEquals(-1, deltaX);
                    assertEquals(0, deltaY);
                    break;
                case EAST:
                    assertEquals(1, deltaX);
                    assertEquals(0, deltaY);
                    break;
                default:
                    throw new AssertionError("Unexpected direction: " + direction);
            }
        }
    }
}