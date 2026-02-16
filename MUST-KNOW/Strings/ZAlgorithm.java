import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public static List<Integer> zSearch(String pattern, String text) {
        // Concatenate pattern, a special character (to avoid overlap), and the text
        String combined = pattern + "$@#$" + text;
        int n = combined.length();
        int[] Z = new int[n];

        calculateZArray(combined, Z);

        List<Integer> result = new ArrayList<>();

        int patternLength = pattern.length();

        for (int i = 0; i < n; i++) {
            if (Z[i] == patternLength) {
                result.add(i - patternLength - 4);
            }
        }
        return result;
    }

    private static void calculateZArray(String patternAndText, int[] Z) {
        int L = 0, R = 0;

        for (int i = 1; i < patternAndText.length(); i++) {
            if (i > R) {
                L = R = i;

                while (R < patternAndText.length() && patternAndText.charAt(R) == patternAndText.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;

            } else {
                // now L and R point to Start-Match-Index(L) and End-Match-Index(R) of pattern(or its prefix) in the String

                if (Z[i-L] < R-i + 1) {

                    Z[i] = Z[i-L];

                } else {
                    L = i;

                    while (R < patternAndText.length() && patternAndText.charAt(R) == patternAndText.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";

        List<Integer> result = zSearch(pattern, text);

        if (result.isEmpty()) {
            System.out.println("Pattern not found in text.");
        } else {
            System.out.println("Pattern found at indices: " + result);
        }
    }
}