public class Fibonacci {
    // Recursive method to calculate Fibonacci number
    public static int fibonacciR(int n) {
        if (n <= 1) {
            return n;  // Base cases: F(0) = 0, F(1) = 1
        }
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacciR(n - 1) + fibonacciR(n - 2);
    }

    // Dynamic Programming method to calculate Fibonacci number
    public static int fibonacciDP(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // Build the table from the bottom up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacciDP(n));
    }
}
