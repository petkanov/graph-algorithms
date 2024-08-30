import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    public static List<Integer> search(String text, String pattern, int prime) {
        List<Integer> result = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        int patternHash = 0; // hash value for the pattern
        int textHash = 0;    // hash value for the current window of text
        int h = 1;
        int d = 256; // number of characters in the input alphabet

        // The value of h would be "pow(d, m-1) % prime"
        int i, j;
        for (i = 0; i < m - 1; i++)
            h = (h * d) % prime;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % prime;
            textHash = (d * textHash + text.charAt(i)) % prime;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // Check the hash values of the current window of text and pattern
            if (patternHash == textHash) {
                // If the hash values match, check characters one by one
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                // If patternHash == textHash and all characters match
                if (j == m)
                    result.add(i);
            }

            // Calculate hash value for the next window of text
            if (i < n - m) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;

                // We might get a negative value of textHash, convert it to positive
                if (textHash < 0)
                    textHash = (textHash + prime);
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