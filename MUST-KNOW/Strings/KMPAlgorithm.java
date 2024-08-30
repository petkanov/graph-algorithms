public class KMPAlgorithm {

    private static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        int len = 0;  // Length of the previous longest prefix suffix

        lps[0] = 0;  // LPS[0] is always 0

        int i = 1;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If there is a mismatch
                if (len != 0) {
                    len = lps[len - 1];  // Don't increment i
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void KMPSearch(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int[] lps = computeLPSArray(pattern);

        int textIndex = 0;  // Index for text
        int patternIndex = 0;  // Index for pattern

        while (textIndex < textLength) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                textIndex++;
                patternIndex++;
            }

            if (patternIndex == patternLength) {
                System.out.println("Found pattern at index " + (textIndex - patternIndex));
                patternIndex = lps[patternIndex - 1];  // Reset j using LPS array to check for more matches
            } else if (textIndex < textLength && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                // Mismatch after j matches
                if (patternIndex != 0) {
                    patternIndex = lps[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABABDACDABABCABAB";
        String pattern = "ABAB"; //  lps[] is [0, 0, 1, 2] 

        // pattern = "AAACAAAAAC"; // lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4] 

        KMPSearch(pattern, text);
    }
}