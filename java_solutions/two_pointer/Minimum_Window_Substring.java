package java_solutions.two_pointer;
/*
    str = "ddaaabbca"
    sub = "abc"
    // Find the minimum length of the substring that contains all the characters of the given substring
    ans = 3 -> "bca"
 */
public class Minimum_Window_Substring {

    // Tc -> O(n + m)
    // Sc -> O(26)
    public static int fn(String str, String sub) {
        int[] vis = new int[26];
        for (char ch : sub.toCharArray()) {
            vis[ch - 'a']++;
        }

        int l = 0, r = 0, minLen = Integer.MAX_VALUE;
        int n = str.length(), ele = 0;

        while (r < n) {
            char ch = str.charAt(r);
            if (vis[ch - 'a'] > 0) ele++;
            vis[ch-'a']--;

            while (ele == sub.length()) {
                minLen = Math.min(minLen, r - l + 1);
                char lc = str.charAt(l);
                vis[lc - 'a']++;
                if (vis[lc - 'a'] > 0) ele--;
                l++;
            }
            r++;
        }

        return minLen;
    }

    public static void main(String[] args) {
        String str = "ddaaabbca";
        String sub = "abc";

        int minLen = fn(str, sub);
        System.out.println(minLen);
    }
}
