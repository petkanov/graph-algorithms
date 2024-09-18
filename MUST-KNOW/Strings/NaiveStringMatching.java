public class NaiveStringMatching {

    public static void main(String[] args) {
        String text = "AABAAC";
        String pattern = "BAA";
        naiveStringMatch(text, pattern);
    }

    public static void naiveStringMatch(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            
            for (int j = 0; j < pattern.length(); j++) {
                
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                if (j == pattern.length() - 1) {
                    System.out.println("Pattern found at index " + i);
                }
            }
        }
    }
}