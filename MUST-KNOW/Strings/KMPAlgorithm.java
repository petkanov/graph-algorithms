public class KMPAlgorithm {

    private static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength]; // Longest Prefix-Suffix: Longest Prefix that is same as some suffix part

        int prefixLengthStreak = 0;
        int patternIndex = 1;

        while (patternIndex < patternLength) {
            
            if (pattern.charAt(prefixLengthStreak) == pattern.charAt(patternIndex)) {
                prefixLengthStreak++;
                lps[patternIndex] = prefixLengthStreak;
                patternIndex++;
            }
            else {
                if (prefixLengthStreak == 0) {
                    lps[patternIndex] = 0;
                    patternIndex++;
                }
                else {
                    prefixLengthStreak = lps[prefixLengthStreak - 1];  // Don't increment patternIndex
                }
            }
        }
        return lps;
    }

    public static void KMPSearch(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int[] lps = computeLPSArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < textLength) {

            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                textIndex++;
                patternIndex++;
            }

            if (patternIndex == patternLength) {
                System.out.println("Found pattern at index " + (textIndex - patternIndex));

                patternIndex = lps[patternIndex - 1];
            }
            else {
                if (textIndex < textLength && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                    if (patternIndex != 0) {
                        patternIndex = lps[patternIndex - 1];
                    } else {
                        textIndex++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABABDACDABABCABABAABA";
        String pattern = "ABAB"; //  lps[] is [0, 0, 1, 2]

        pattern = "ABABD"; //  lps[] is [0, 0, 1, 2, 0]
//        pattern = "ABAABA";      //  lps[] is [ 0, 0, 1, 1, 2, 3 ]
//        pattern = "BBABCABBB";
//      lps[] is [ 010100122 ]
//        pattern = "ABAABAAA";      //  lps[] is [ 0, 0, 1, 1, 2, 3, 4, 1 ]
//        pattern = "AAACAAAAAC"; //  lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
//        pattern = "AAACAACAAAC"; // lps[] is [0, 1, 2, 0, 1, 2, 0, 1, 2, 3, 4]

        KMPSearch(pattern, text);
    }
}