package java_solutions.two_pointer;

import java.util.Arrays;

/*
    Fruit into buckets
    -> only collect unique fruits, and you have two buckets
    -> max length sub array with almost two types of numbers
    arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
    ans = 5 -> [1, 2, 1, 1, 2]
    type 1 - return maxLen -> 5
    type 2 - return maxLen sub array -> [1, 2, 1, 1, 2]
 */
public class Fruit_Into_Buckets {

    // Tc -> O(n)
    // Sc -> O(1)
    public static int type1(int[] arr) {
        int n = arr.length;
        int[] vis = new int[arr.length];
        int l = 0, r = 0, maxLen = Integer.MIN_VALUE;
        int fruits = 0;

        while (r < n) {
            if (vis[arr[r]] == 0) fruits++;

            if (fruits > 2) {
                vis[arr[l]]--;
                if (vis[arr[l]] == 0) fruits--;
                l++;
            } else {
                maxLen = Math.max(maxLen, r-l+1);
            }
            vis[arr[r]]++;
            r++;
        }

        return maxLen;
    }

    // Tc -> O(n)
    // Sc -> O(maxLen)
    public static int[] type2(int[] arr) {
        int n = arr.length;
        int fruits = 0, maxLen = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int arrStart = 0, arrEnd = 0;
        int[] vis = new int[arr.length];

        while (r < n) {
            if (vis[arr[r]] == 0)
                fruits++;

            if (fruits > 2) {
                vis[arr[l]]--;
                if (vis[arr[l]] == 0)
                    fruits--;
                l++;
            } else {
                int len = r-l+1;
                if (maxLen < len) {
                    maxLen = len;
                    arrStart = l;
                    arrEnd = r;
                }
            }
            vis[arr[r]]++;
            r++;
        }

        return Arrays.copyOfRange(arr, arrStart, arrEnd+1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        int maxLen = type1(arr);
        int[] ans = type2(arr);

        System.out.println(maxLen);
        System.out.println(Arrays.toString(ans));
    }
}
