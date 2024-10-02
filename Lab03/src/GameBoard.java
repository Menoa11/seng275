public class GameBoard {
    private final int size = 6;

    public boolean isWithinBoard(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return true;
        } else {
            throw new IllegalArgumentException("Coordinates (" + x + ", " + y + ") are outside the board.");
        }
    }
}

