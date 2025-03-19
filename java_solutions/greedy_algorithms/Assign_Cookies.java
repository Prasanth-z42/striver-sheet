package java_solutions.greedy_algorithms;
/*
    Leetcode -> 455

    children = {1, 5, 3, 3, 4}
    cookies = {4, 2, 1, 2, 1, 3}

    ans = 3 children's
 */
import java.util.Arrays;

public class Assign_Cookies {

    // Tc -> O(n log n) + O(m log m) + O(m)
    // Sc -> O(1)
    public static int fn(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int m = s.length;
        int l = 0, r = 0;

        while (l < m) {
            if (g[r] <= s[l])
                r++;
            l++;
        }

        return r;
    }

    public static void main(String[] args) {
        int[] children = {1, 5, 3, 3, 4};
        int[] cookies = {4, 2, 1, 2, 1, 3};

        int ans = fn(children, cookies);
        System.out.println(ans);
    }
}
