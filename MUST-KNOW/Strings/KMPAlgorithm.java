public class KMPAlgorithm {

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()]; // LongestPrefixSuffix: Longest Prefix that is in some part of suffinx at index "i"

        int prefixStreakLength = 0;
        int patternIndex = 1;

        while (patternIndex < pattern.length()) {
            
            if (pattern.charAt(prefixStreakLength) == pattern.charAt(patternIndex)) {
                prefixStreakLength++;
                lps[patternIndex] = prefixStreakLength;
                patternIndex++;
            }
            else {
                if (prefixStreakLength == 0) {
                    lps[patternIndex] = 0;
                    patternIndex++;
                }
                else {
                    prefixStreakLength = lps[prefixStreakLength - 1];
                }
            }
        }
        return lps;
    }

    public static void KMPSearch(String pattern, String text) {
        int[] lps = computeLPSArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {

            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                textIndex++;
                patternIndex++;
            }

            if (patternIndex == pattern.length()) {
                System.out.println("Found pattern at index " + (textIndex - pattern.length()));

                patternIndex = lps[patternIndex - 1];
            }
            else {
                if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                    if (patternIndex == 0) {
                        textIndex++;
                    } else {
                        patternIndex = lps[patternIndex - 1];
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