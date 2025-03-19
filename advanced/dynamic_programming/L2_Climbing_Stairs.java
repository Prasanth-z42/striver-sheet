package java_solutions.dynamic_programming;

public class L2_Climbing_Stairs {
    public static void main(String[] args) {
        int n = 3;
        climbingStairs(n);
    }

    public static void climbingStairs(int n) {
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
        if (n <= 1) return 1;

        int one = f1(n-1);
        int two = f1(n-2);

        return one + two;
    }

    public static int f2(int n, int[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != 0) return dp[n];

        int one = f2(n-1, dp);
        int two = f2(n-2, dp);

        return dp[n] = one + two;
    }

    public static int f3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int f4(int n) {
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i<=n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
