package java_solutions.two_pointer;
/*
    str = "aaabbccd", k = 2
    ans = 5 -> "aaabb"
 */
public class Longest_Substring_AtMost_K_Distinct_Chars {

    // Tc -> O(n)
    // Sc -> O(26)
    public static int fn(String str, int k) {
        int[] vis = new int[26];
        int l = 0, r = 0, maxLen = Integer.MIN_VALUE;
        int ele = 0, n = str.length();
        int start = 0, end = 0;  // find the longest substring?

        while (r < n) {
            char ch = str.charAt(r);
            if (vis[ch-'a'] == 0) ele++;

            if (ele > k) {
                int i = vis[str.charAt(l) - 'a']--;
                if (i == 0) ele--;
                l++;
            } else {
                int len = r - l + 1;
                if (maxLen < len) {   // longest substring
                    maxLen = len;
                    start = l;
                    end = r+1;
                }
            }

            vis[ch-'a']++;
            r++;
        }

        System.out.println("Longest Substring : " + str.substring(start, end));
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "aaabbccd";
        int k = 2;

        int maxLen = fn(str, k);
        System.out.println(maxLen);
    }
}
