package java_solutions.dynamic_programming;

public class L34_WildCard_Matching {
    public static void main(String[] args) {
        String s1 = "*";
        String s2 = "aa";

        wildCardMatch(s1, s2);
    }

    public static void wildCardMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // recursive and memoization
        boolean ans1 = f1(n, m, s1, s2, new boolean[n+1][m+1]);
        System.out.println(ans1);

        // tabulation
        boolean ans2 = f2(n, m, s1, s2);
        System.out.println(ans2);

        // space optimization
        boolean ans3 = f3(n, m, s1, s2);
        System.out.println(ans3);
    }

    public static boolean f1(int i, int j, String s1, String s2, boolean[][] dp) {
        if (i == 0 && j == 0) return true;
        if (i == 0 && j > 0) return false;
        if (j == 0 && i > 0) {
            for (int k = 1; k<=i; k++) {
                if (s1.charAt(k-1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j]) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
            return dp[i][j] = f1(i-1, j-1, s1, s2, dp);

        if (s1.charAt(i-1) == '*')
            return dp[i][j] = f1(i-1, j, s1, s2, dp) || f1(i, j-1, s1, s2, dp);

        return dp[i][j] = false;
    }

    public static boolean f2(int n, int m, String s1, String s2) {
        boolean[][] dp = new boolean[n+1][m+1];
        // base cases
        // first
        dp[0][0] = true;
        // second
        for (int j = 1; j<=m; j++) dp[0][j] = false;
        // third
        for (int i = 1; i<=n; i++) {
            boolean flag = true;
            for (int k = 1; k<=i; k++) {
                if (s1.charAt(k-1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];

                else if (s1.charAt(i-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }

    public static boolean f3(int n, int m, String s1, String s2) {
        boolean[] prev = new boolean[m+1];
        boolean[] curr = new boolean[m+1];
        // base cases
        // first
            prev[0] = true;
        // second
            for (int j = 1; j<=m; j++) prev[j] = false;
        // third -> do not need

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
                    curr[j] = prev[j-1];

                else if (s1.charAt(i-1) == '*')
                    curr[j] = prev[j] || curr[j-1];

                else curr[j] = false;
            }
            prev = curr.clone();
        }

        return prev[m];
    }
}
