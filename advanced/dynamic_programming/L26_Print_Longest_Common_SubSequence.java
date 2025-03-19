package java_solutions.dynamic_programming;

public class L26_Print_Longest_Common_SubSequence {
    public static void main(String[] args) {
        String s1 = "abcab", s2 = "cbab";

        printLongestCommonSubSequence(s1, s2, s1.length(), s2.length());
    }

    public static void printLongestCommonSubSequence(String s1, String s2, int n, int m) {
        String ans =  f(s1, s2, n, m);  // same code as DP - 25
        System.out.println(ans);
    }

    public static String f(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];

        // baseCase

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j] >= dp[i][j-1]) i--;
                else j--;
            }
        }

        return sb.reverse().toString();
    }
}
