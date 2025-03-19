package java_solutions.arrays;
import java.util.*;
public class TwoSum {

    // optimal ->
    // tc -> O(n log n) + O(n) and sc -> O(1)
    public static int[] twoSum(int[] arr, int k) {
        Arrays.sort(arr);
        int l = 0, r = arr.length-1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == k) {
                return new int[] {l, r};
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }

        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 11};
        int k = 8;
        int[] ans = twoSum(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    /*
    // better ->
    // tc -> O(2n) and sc -> O(n)
    public static int[] twoSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i<n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i<n; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                return new int[] {i, map.get(rem)};
            }
        }

        return new int[] {-1, -1};
    }

    // brute ->
    // tc -> O(n^2) and sc -> O(1)
    public static int[] twoSum(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (arr[i] + arr[j] == k)
                    return new int[]{i, j};
            }
        }
        return new int[] {-1, -1};
    }
    */
}
