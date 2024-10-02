import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
    private static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        s = s.toUpperCase();

        int convertedNumber = 0;
        int previousNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!map.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + currentChar);
            }

            int currentNumber = map.get(currentChar);

            if (currentNumber > previousNumber && previousNumber != 0) {
                if (isInvalidSubtractiveCombination(previousNumber, currentNumber)) {
                    throw new IllegalArgumentException("Invalid subtractive combination: " + s);
                }
                convertedNumber -= 2 * previousNumber;
            }

            convertedNumber += currentNumber;
            previousNumber = currentNumber;
        }

        if (hasInvalidRepetitions(s)) {
            throw new IllegalArgumentException("Invalid repetitions in: " + s);
        }

        return convertedNumber;
    }

    private boolean isInvalidSubtractiveCombination(int previous, int current) {
        return (previous == 1 && current > 10) ||
                (previous == 10 && current > 100) ||
                (previous == 100 && current > 1000);
    }

    private boolean hasInvalidRepetitions(String s) {
        String[] invalidPatterns = {"IIII", "VV", "XXXX", "LL", "CCCC", "DD", "MMMM"};
        for (String pattern : invalidPatterns) {
            if (s.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}


