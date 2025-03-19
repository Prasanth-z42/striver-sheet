package java_solutions.dynamic_programming;

import java.util.Arrays;

public class L32_Distinct_Sequence {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        // how many times appears string 2 to in string 1
        // ans -> 5
        distinctSequence(s1, s2);
    }

    public static void distinctSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        int ans = f1(n, m, s1, s2, dp);
        System.out.println(ans);

        int ans2 = f2(n, m, s1, s2);
        System.out.println(ans2);

        int ans3 = f3(n, m, s1, s2);
        System.out.println(ans3);
    }

    public static int f2(int n, int m, String s1, String s2) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i<=n; i++) dp[i][0] = 1;

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][m];
    }

    public static int f3(int n, int m, String s1, String s2) {
        int[] dp = new int[m+1];
        dp[0] = 1;

        for (int i = 1; i<=n; i++) {
            for (int j = m; j>=1; j--) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }

        return dp[m];
    }

    public static int f1(int i, int j, String s1, String s2, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = f1(i-1, j-1, s1, s2, dp) + f1(i-1, j, s1, s2, dp);
        return dp[i][j] = f1(i-1, j, s1, s2, dp);
    }
}
