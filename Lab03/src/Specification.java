public class Specification {
    protected static int width = 1280;
    protected static int height = 720;  // helper variables for insideDisplayArea

    /**
     *  Returns true if the given point's x and y coordinates are within the
     *  addressable pixel area of a display.  Point 0,0 is the upper-left corner, and
     *  points on the edges or in the corner (for example, 0,0) are considered to be within the area.
     *
     *  The display has two modes, FHD (for Full High Definition) and HD (for High Definition).
     *  The definition can be changed by calling a separate setDefinition(mode), with mode:
     *      0 - HD,  1280 wide x 720 high
     *      1 - FHD, 1920 wide x 1080 high
     *  If setDefinition() has not yet been called, the display is in HD mode.
     *
     * @param x     The distance from the left edge of the display in pixels
     * @param y     The distance from the top edge of the display in pixels
     * @return bool True if the pixel lies within the area of the display or on its edge
     */
    public static boolean insideDisplayArea(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public static void setDefinition(int mode) {
        // Do not test this function; it is here only to help you understand the comment above.
        width = (mode == 0) ? 1280 : 1920;
        height = (mode == 0) ? 720 : 1080;
    }


    /** Evaluates a personalized BC license plate message for validity according to some rules
     * at https://www.icbc.com/vehicle-registration/licence-plates/Pages/Personalized-licence-plates.aspx
     *
     * Specifically the message must:
     *  - have 2-6 letters or letters and numbers
     *  - can include blank spaces or hyphens (each such space or hyphen must have a letter or number
     *      both before it and after it).
     *  - can be a maximum of 7 characters if it contains a hyphen (a maximum of 6 characters if the
     *      plate is for a motorcycle).
     *  - must not be composed only of numbers
     *
     *  Only the rules above are used for this exercise; any other rules on the icbc website other than the ones
     *  above may be disregarded.
     *
     * @param input     The intended message
     * @param motorcycle True for a motorcycle, false otherwise
     * @return          True if the message is valid according to these rules
     */

    public static boolean messageIsValid(String input, boolean motorcycle) {
        if (input.length() < 2) return false;
        if ((motorcycle && input.length() > 6) || (!motorcycle && input.length() > 7)) return false;
        if (input.startsWith(" ") || input.startsWith("-") ||
                input.endsWith("-") || input.endsWith(" ")) return false;
        char[] chars = input.toCharArray();
        boolean all_numbers = true;
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch) && ch != ' ' && ch != '-') {
                return false;
            }
            if (!Character.isDigit(ch)) all_numbers = false;
        }
        if (all_numbers) return false;
        for (int i = 0; i < input.length() - 1; i++) {
            if (chars[i] == ' ' || chars[i] == '-') {
                if (!(Character.isLetterOrDigit(chars[i - 1]) && Character.isLetterOrDigit(chars[i + 1]))) {
                    return false;
                }
            }
        }
        return true;
    }
}


