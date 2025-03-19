package java_solutions.dynamic_programming;

        // logic -> lcs(s1, s2) -> etco -> size 4
        // n = 8, m = 4  (string lengths)
        // (n - size) + (m - size)
        // (8 - 4) + (4 - 4) -> 4 + 0
        // ans ---> 4

public class L30_Minimum_InsertionOrDeletion_To_Make_S1_To_S2 {

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "etco";

        int n = s1.length();
        int m = s2.length();

        int ans = lcs(s1, s2, n, m);
        System.out.println(ans);
    }
    // same code as longest common subsequence
    public static int lcs(String s1, String s2, int n, int m) {
        int[] dp = new int[m+1];
        int[] curr = new int[m+1];

        // baseCase

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(curr[j-1], dp[j]);
            }
            dp = curr.clone();
        }

        return dp[m];
    }
}
