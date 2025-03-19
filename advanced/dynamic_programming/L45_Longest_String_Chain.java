package java_solutions.dynamic_programming;

import java.util.Arrays;

public class L45_Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        String[] words2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};  // sort by length

        int ans = longestStringChain(words2); // same code as LIC slightly change
        System.out.println(ans);
    }

    public static int longestStringChain(String[] arr) {
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(arr[i], arr[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;

        int i = 0, j = 0;
        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j))
                j++;
            i++;
        }

        return j == s2.length();
    }
}
