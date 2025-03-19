package java_solutions.dynamic_programming;

public class L28_Longest_Palindrome_SubSequence {
    public static void main(String[] args) {
        String str = "mama";

        longestPalindromeSubsequence(str);
    }

    public static void longestPalindromeSubsequence(String s1) {
        // same code as longest common subsequence
        String s2 = new StringBuilder(s1).reverse().toString();

        int ans = lcs(s1, s2, s1.length());
        System.out.println(ans);
    }

    public static int lcs(String s1, String s2, int n) {
        int[] dp, curr;
        dp = curr = new int[n+1];

        // baseCase

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(curr[j-1], dp[j]);
            }
            dp = curr.clone();
        }

        return dp[n];
    }

}
