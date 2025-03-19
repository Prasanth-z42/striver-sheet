package java_solutions.dynamic_programming;

public class L1_Fibonacci_No {
    public static void main(String[] args) {
        int n = 5;
        fibonacci(n);
    }

    public static void fibonacci(int n) {
        if (n <= 1) System.out.println(n);

        // Recursive
        int ans1 = f1(n);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n, new int[n+1]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n);
        System.out.println(ans4);
    }

    public static int f1(int n) {
        if (n <= 1) return n;
        return f1(n-1) + f1(n-2);
    }

    public static int f2(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = f2(n-1, dp) + f2(n-2, dp);
    }

    public static int f3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int f4(int n) {
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i<=n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
