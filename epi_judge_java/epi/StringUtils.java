package epi;

public class StringUtils {
    private static String reverseWithXOR(String line) {
        char[] lineChars = line.toCharArray();
        int length = line.length();
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            lineChars[i] ^= lineChars[length - i - 1];
            lineChars[length - i - 1] ^= lineChars[i];
            lineChars[i] ^= lineChars[length - i - 1];
        }
        return String.valueOf(lineChars);
    }

    private static String reverseWithVar(String line) {
        char[] lineChars = line.toCharArray();
        int length = lineChars.length;
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            char temp = lineChars[i];
            lineChars[i] = lineChars[length - i - 1];
            lineChars[length - i - 1] = temp;
        }
        return String.valueOf(lineChars);
    }

    // XOR operation is slower in 3-4 times than usage of temporary variable
    public static void main(String[] args) {
        String line = "Test line here";
        long startTime = System.nanoTime();
        System.out.printf("%s => %s | finished in: %s nanoseconds%n",
                line, StringUtils.reverseWithXOR(line), System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.printf("%s => %s | finished in: %s nanoseconds%n",
                line, StringUtils.reverseWithVar(line), System.nanoTime() - startTime);
    }
}
