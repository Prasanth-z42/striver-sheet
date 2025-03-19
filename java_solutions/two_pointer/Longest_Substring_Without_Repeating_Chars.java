package java_solutions.two_pointer;
/*
    str = "zohocorporation"
    type - 1 = 6 -> "porati" or "ration"
    type - 2 = [porati, ration]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Substring_Without_Repeating_Chars {

    // Tc -> O(n)
    // Sc -> O(256)
    public static int type1(String str) {
        int[] vis = new int[256];
        Arrays.fill(vis, -1);
        int l = 0, r = 0, maxLen = 0;

        while (r < str.length()) {
            char ch = str.charAt(r);
            if (vis[ch] != -1) {
                if (vis[ch] >= l)
                    l = vis[ch] + 1;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            vis[ch] = r;
            r++;
        }

        return maxLen;
    }

    // Tc -> O(2n)
    // Sc -> O(256)
    public static List<String> type2(String str) {
        int[] vis = new int[256];
        Arrays.fill(vis, -1);
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0, maxLen = type1(str);

        while (r < str.length()) {
            char ch = str.charAt(r);

            if (vis[ch] != -1) {
                if (vis[ch] >= l)
                    l = vis[ch] + 1;
            }

            int len = r - l + 1;
            if (len == maxLen) {
                ans.add(str.substring(l, r+1));
            }

            vis[ch] = r;
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "zohocorporation";

        int maxLen = type1(str);
        List<String> ans  = type2(str);

        System.out.println(maxLen);
        System.out.println(ans);
    }
}
