package java_solutions.two_pointer;

import java.util.Arrays;

public class No_Of_Substrings_Containing_All_Three_Chars {

    // Tc -> O(n)
    // Sc -> O(3)
    public static int fn(String str) {
        int n = str.length();
        int[] vis = new int[3];
        int count = 0;

        Arrays.fill(vis,  -1);
        for (int i = 0; i<n; i++) {
            vis[str.charAt(i) - 'a'] = i;
            if (vis[0] != -1 && vis[1] != -1 && vis[2] != -1)
                count += (1 + min(vis));
        }

        return count;
    }

    public static int min(int[] arr) {
        return Math.min(arr[0], Math.min(arr[1], arr[2]));
    }

    public static void main(String[] args) {
        String str = "bbacba";

        int count = fn(str);
        System.out.println(count);
    }
}
