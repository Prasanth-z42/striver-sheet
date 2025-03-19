package java_solutions.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class L43_LIS_Using_Binary_Search {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};

        int ans = LISUsingBinarySearch(arr);
        System.out.println(ans);
    }

    public static int LISUsingBinarySearch(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i<n; i++) {
            if (arr[i] > ans.get(ans.size()-1)) {
                ans.add(arr[i]);
            } else {
                int ind = binarySearch(arr[i], ans);
                ans.set(ind, arr[i]);
            }
        }

        return ans.size();
    }

    public static int binarySearch(int val, List<Integer> arr) {
        int n = arr.size();

        int low = 0, high = n-1;
        int ind = n;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) >= val) {
                ind = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ind;
    }
}
