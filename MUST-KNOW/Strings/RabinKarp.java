import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    
    public static List<Integer> search(String text, String pattern, int prime) {
        List<Integer> result = new ArrayList<>();

        int numOfCharsInAlphabet = 256;
        int patternHash = 0;
        int textWindowHash = 0;

        // The value of h would be "pow(numOfCharsInAlphabet, m-1) % prime"
        int h = 1;
        for (int i = 0; i < pattern.length()-1; i++) {
            h = (h * numOfCharsInAlphabet) % prime;
        }
        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < pattern.length(); i++) {
            patternHash    = (numOfCharsInAlphabet * patternHash + pattern.charAt(i)) % prime;
            textWindowHash = (numOfCharsInAlphabet * textWindowHash + text.charAt(i)) % prime;
        }
        // Slide the pattern over text one by one
        for (int i = 0; i <= text.length() - pattern.length(); i++) {

            if (patternHash == textWindowHash) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                    if (j == pattern.length()-1){
                        result.add(i);
                    }
                }
            }
            // Calculate hash value for the next window of text
            if (i < text.length() - pattern.length()) {
                textWindowHash = (numOfCharsInAlphabet * (textWindowHash - text.charAt(i)*h) + text.charAt( i+pattern.length()) ) % prime;
                // We might get a negative value of textWindowHash, convert it to positive
                if (textWindowHash < 0) {
                    textWindowHash += prime;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        pattern = "ABAB";
        int prime = 101; // A prime number for modulo operation

        List<Integer> result = search(text, pattern, prime);

        if (!result.isEmpty()) {
            System.out.println("Pattern found at positions: " + result);
        } else {
            System.out.println("Pattern not found");
        }
    }
}