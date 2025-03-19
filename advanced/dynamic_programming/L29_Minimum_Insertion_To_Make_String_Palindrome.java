package java_solutions.dynamic_programming;

public class L29_Minimum_Insertion_To_Make_String_Palindrome {
    public static void main(String[] args) {
        String s = "codingninjas";
        int n = s.length();

        // formula  -->  (s.length() - lcs(s, rev(s))
        int ans = n - lcs(s, new StringBuilder(s).reverse().toString(), n);
        System.out.println(ans);
    }

    // same code as longest common subsequence
    public static int lcs(String s1, String s2, int n) {
        int[] dp = new int[n+1];
        int[] curr = new int[n+1];

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
