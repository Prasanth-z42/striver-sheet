package java_solutions.dynamic_programming;

public class L25_Longest_Common_SubSequence {
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";

        longestCommonSubsequence(s1, s2);
    }

    public static void longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // recursive & memoization
        int ans1 = f1(n, m, s1, s2, new int[n+1][m+1]);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(s1, s2, n, m);
        System.out.println(ans2);

        // space optimization
        int ans3 = f3(s1, s2, n, m);
        System.out.println(ans3);
    }

    public static int f1(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + f1(i-1, j-1, s1, s2, dp);
        return dp[i][j] = Math.max(f1(i, j-1, s1, s2, dp), f1(i-1, j, s1, s2, dp));
    }

    public static int f2(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];

        // baseCase
        for (int i = 0; i<=n; i++) dp[i][0] = 0;
        for (int j = 0; j<=m; j++) dp[0][j] = 0;

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[n][m];
    }

    public static int f3(String s1, String s2, int n, int m) {
        int[] dp, curr;
        dp = curr = new int[m+1];

        // baseCase
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(curr[j-1], dp[j]);
            }
            dp = curr;
        }

        return dp[m];
    }
}
