public class ArrayUtils {
    public static boolean isSorted(final int[] array) {
        if (array == null || array.length < 2) {
            return true;
        }
        int previous = array[0];
        final int n = array.length;
        for (int i = 1; i < n; i++) {
            final int current = array[i];
            if (previous > current) {
                return false;
            }
            previous = current;

        }
        return true;
    }
}
