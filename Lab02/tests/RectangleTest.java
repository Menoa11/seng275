import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void defaultRectangle() {
        Rectangle r = new Rectangle();
        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
        assertEquals(1, r.getWidth());
        assertEquals(1, r.getHeight());
    }
    @Test
    void customRectangle() {
        Rectangle r = new Rectangle(5,5,10,10);
        assertEquals(5, r.getX());
        assertEquals(5, r.getY());
        assertEquals(10, r.getWidth());
        assertEquals(10, r.getHeight());
    }
    @Test
    void changeRectangle() {
        Rectangle r = new Rectangle(5,5,10,10);
        r.setX(10);
        r.setY(10);
        r.setWidth(20);
        r.setHeight(20);
        assertEquals(10, r.getX());
        assertEquals(10, r.getY());
        assertEquals(20, r.getWidth());
        assertEquals(20, r.getHeight());
    }
    @Test
    void negativeWidth() {
        Rectangle r = new Rectangle(5,5,10,10);
        assertThrows(IllegalArgumentException.class, () -> r.setWidth(-1));
    }
    @Test
    void negativeHeight() {
        Rectangle r = new Rectangle(5,5,10,10);
        assertThrows(IllegalArgumentException.class, () -> r.setHeight(0));
    }
    @Test
    void equality() {
        Rectangle r1 = new Rectangle(5,5,10,10);
        Rectangle r2 = new Rectangle(5,5,10,10);
        assertTrue(r1.equals(r2));
    }
    @Test
    void area() {
        Rectangle r1 = new Rectangle(5,5,10,10);
        assertEquals(100, r1.getArea());
    }
    @Test
    void containsRectangle() {
        Rectangle r1 = new Rectangle(5,5,10,10);
        Rectangle r2 = new Rectangle(5,5,5,5);
        assertTrue(r1.contains(r2));
    }

}