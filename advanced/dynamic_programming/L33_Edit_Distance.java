package java_solutions.dynamic_programming;

public class L33_Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        /*
            how many times of operation requires to the given string s1 convert into s2.
            1. insert
            2. delete
            3. replace

            horse -> ros
         */

        minDistance(s1, s2);
    }

    public static void minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // recursion and memoization
        int ans1 = f1(n, m, s1, s2, new int[n+1][m+1]);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(n, m, s1, s2);
        System.out.println(ans2);

        // space optimization
        int ans3 = f3(n, m, s1, s2);
        System.out.println(ans3);
    }

    public static int f1(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] !=  0) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = f1(i-1, j-1, s1, s2, dp);

        int insert = 1 + f1(i, j-1, s1, s2, dp);
        int delete = 1 + f1(i-1, j, s1, s2, dp);
        int replace = 1 + f1(i-1, j-1, s1, s2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public static int f2(int n, int m, String s1, String s2) {
        int[][] dp = new int[n+1][m+1];

        for (int j = 0; j<=m; j++) dp[0][j] = j;
        for (int i = 0; i<=n; i++) dp[i][0] = i;

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static int f3(int n, int m, String s1, String s2) {
        int[] dp = new int[m+1];
        int[] curr = new int[m+1];

        for (int j = 0; j<=m; j++) dp[j] = j;

        for (int i = 1; i<=n; i++) {
            curr[0] = i;
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = dp[j - 1];
                } else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + dp[j];
                    int replace = 1 + dp[j - 1];

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            dp = curr.clone();
        }

        return dp[m];
    }
}
