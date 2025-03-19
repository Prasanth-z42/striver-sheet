package java_solutions.arrays;
/*
    arr = {{1, 3},{2, 6},{8, 10},{15, 18}}
    ans = [[1, 6], [8, 10], [15, 18]]

    arr = {{1, 4}, {0, 4}}
    ans = [[0, 4]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

    // Tc -> O(n log n) + O(n)
    // Sc -> O(n) maybe
    public static List<int[]> mergeIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i<arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && start <= ans.get(ans.size()-1)[1]) {
                ans.get(ans.size()-1)[1] = end;
            } else {
                ans.add(new int[]{start, end});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3},{2, 6},{8, 10},{15, 18}};
        //int[][] arr = {{1, 4}, {0, 4}};
        List<int[]> ans = mergeIntervals(arr);
        for (int[] a : ans) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }
}
