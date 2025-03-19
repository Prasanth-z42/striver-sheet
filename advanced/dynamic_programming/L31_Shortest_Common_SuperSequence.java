package java_solutions.dynamic_programming;

public class L31_Shortest_Common_SuperSequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        shortestCommonSuperSequence(s1, s2);
    }

    public static void shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int lcsLen = lcs(n, m, s1, s2, dp);
        // formula
        //    s1.length() + s2.length() - lcs.length() -> 5 + 5 - 2 -> 8
        //    lcs string "rt" len of 2
        int ans = n + m - lcsLen;
        System.out.println("minLen : " + ans);

        // print the string
        String str = printString(dp, n, m, s1, s2);
        System.out.println("super sequence : " + str);
    }

    public static String printString(int[][] dp, int n, int m, String s1, String s2) {
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                sb.append(s1.charAt(i-1));
                i--;
            } else {
                sb.append(s2.charAt(j-1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i-1));
            i--;
        }

        while (j > 0) {
            sb.append(s2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
    public static int lcs(int n, int m, String s1, String s2) {
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }

    public static int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + lcs(i-1, j-1, s1, s2, dp);
        return dp[i][j] = Math.max(lcs(i-1, j, s1, s2, dp), lcs(i, j-1, s1, s2, dp));
    }
}
