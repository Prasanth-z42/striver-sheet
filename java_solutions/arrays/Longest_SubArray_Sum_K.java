package java_solutions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    // including zeros
    arr = {1, 2, 1, 0, 4}, k = 4
    maxLen = 4 -> {1, 2, 1, 0}

    // non-zeros
    arr2 = {1, 2, 1, 1, 1}, k = 6
    maxLen = 5 -> {1, 1, 1, 1, 2}

    // leetcode
    arr3 = {1, 2, 1, 2, 1}, k = 3
    maxLen = 4 -> {1, 2, 1, 2}
 */
public class Longest_SubArray_Sum_K {

    // Hashing
    // Tc -> O(n) and Sc -> O(n)
    public static int longestSubArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i<arr.length; i++) {
            sum += arr[i];
            if (sum == k)
                maxLen = Math.max(maxLen, i+1);

            int rem = k - sum;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return maxLen;
    }

    // 2-pointer
    // Tc -> O(n log n) + O(n) and Sc -> O(1)
    public static int longestSubArray2(int[] arr, int k) {
        Arrays.sort(arr);
        int l = 0, r = 0, maxLen = 0, sum = arr[0];
        int n = arr.length;

        while (r < n) {
            while (l <= r && sum > k) {
                sum -= arr[l];
                l++;
            }

            if (sum == k)
                maxLen = Math.max(maxLen, r-l+1);

            r++;
            if (r < n) sum += arr[r];
        }

        return maxLen;
    }

    // leetcode
    // Tc -> O(n) and Sc -> O(n)
    public static int longestSubArray3(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;

        map.put(0, 1);
        for (int i = 0; i<arr.length; i++) {
            sum += arr[i];
            int rem = sum - k;

            if (map.containsKey(rem))
                maxLen += map.get(rem);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 0, 4}; // including zeros
        int k1 = 4;
        System.out.println(longestSubArray(arr1, k1));

        int[] arr2 = {1, 2, 1, 1, 1}; // non-zeros
        int k2 = 6;
        System.out.println(longestSubArray2(arr2, k2));

        int[] arr3 = {1, 2, 1, 2, 1};
        int k3 = 3;
        System.out.println(longestSubArray3(arr3, k3));
    }
}
