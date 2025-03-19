package java_solutions.dynamic_programming;

public class L27_Longest_Common_String {
    public static void main(String[] args) {
        String s1 = "edcba";
        String s2 = "abcde";

        lcs(s1, s2);
    }

    public static void lcs(String s1, String s2) {
        // same code as longest common subsequence (slightly change the code)
        int n = s1.length();
        int m = s2.length();
        // print max len
        int ans =  f(s1, s2, n, m);
        System.out.println(ans);

        // space optimization
        int ans2 = f2(s1, s2, n, m);
        System.out.println(ans2);

        // print max substring
        String str = f3(s1, s2, n, m);
        System.out.println(str);
    }

    public static int f(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int maxi = 0;
        // baseCase

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxi = Math.max(maxi, dp[i][j]);
                } else {
                    dp[i][j] = 0;          // change this line
                }
            }
        }

        return maxi;
    }


    public static int f2(String s1, String s2, int n, int m) {
        int[] dp, curr;
        dp = curr = new int[m+1];
        int maxi = 0;
        // baseCase

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + dp[j - 1];
                    maxi = Math.max(maxi, curr[j]);
                } else {
                    curr[j] = 0;          // change this line
                }
            }
            dp = curr.clone();
        }

        return maxi;
    }

    public static String f3(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int maxi = 0;
        // baseCase

        int endInd = 0;
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (maxi <= dp[i][j]) {
                        maxi = dp[i][j];
                        endInd = i;
                    }
                } else {
                    dp[i][j] = 0;          // change this line
                }
            }
        }

        return s1.substring(endInd-maxi, endInd);
    }

}
