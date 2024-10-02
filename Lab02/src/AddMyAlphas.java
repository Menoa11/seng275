public class AddMyAlphas {
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();
        for (String num : nums) {
            int n = Integer.parseInt(num.trim());
            if (n < 0) {
                if (!negativeNumbers.isEmpty()) {
                    negativeNumbers.append(",");
                }
                negativeNumbers.append(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
        return sum;
    }
}
