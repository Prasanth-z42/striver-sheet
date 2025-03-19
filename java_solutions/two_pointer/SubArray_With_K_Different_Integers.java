package java_solutions.two_pointer;
/*
    arr = {2, 1, 1, 1, 3, 4, 3, 2}, k = 3
    ans = 7
    fn(arr, k) - fn(arr, k-1)
 */

import java.util.HashMap;
import java.util.Map;

public class SubArray_With_K_Different_Integers {

    // Tc -> O(2n)
    // Sc -> O(1)
    public static int fn(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while (r < n) {
            while (map.size() > k) {
                map.put(arr[l], map.get(arr[l])-1);
                if (map.get(arr[l]) == 0)
                    map.remove(arr[l]);
                l++;
            }
            count += (r - l + 1);
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 3, 4, 3, 2};
        int k = 3;

        int ans = fn(arr, k) - fn(arr, k-1);
        System.out.println(ans);
    }
}
