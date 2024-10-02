import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddMyAlphasTest {
    @Test
    public void emptyString() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(0, adder.Add(""));
    }

    @Test
    public void oneNumber() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(1, adder.Add("1"));
    }

    @Test
    public void twoNumbers() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(3, adder.Add("1,2"));
    }

    @Test
    public void unknownNumberOfNumbers() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(6, adder.Add("1,2,3"));
        assertEquals(10, adder.Add("1\n2,3,4"));
    }

    @Test
    public void newLines() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(6, adder.Add("1\n2,3"));
    }

    @Test
    public void negativeNumbers() {
        AddMyAlphas adder = new AddMyAlphas();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            adder.Add("1,-2");
        });
        assertEquals("Negatives not allowed: -2", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            adder.Add("2,-4,3,-5");
        });
        assertEquals("Negatives not allowed: -4,-5", exception.getMessage());
    }

    @Test
    public void greaterThan1000() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(2, adder.Add("1001,2"));
    }

    @Test
    public void delimiters() {
        AddMyAlphas adder = new AddMyAlphas();
        assertEquals(3, adder.Add("//;\n1;2"));
        assertEquals(10, adder.Add("//sep\n2sep3sep5"));
    }
}
