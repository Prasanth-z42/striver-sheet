package java_solutions.greedy_algorithms;
import java.util.*;
public class Insert_Intervals {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {3, 4},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = {5, 8};

        List<int[]> ans = insertIntervals(arr, newInterval);

        for (int[] a : ans) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }

    public static List<int[]> insertIntervals(int[][] arr, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = arr.length;

        int i = 0;
        while (i < n && arr[i][1] < newInterval[0]) {
            ans.add(arr[i]);
            i++;
        }

        while (i < n && arr[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], arr[i][0]);
            newInterval[1] = Math.max(newInterval[1], arr[i][1]);
            i++;
        }
        ans.add(newInterval);

        while (i < n) {
            ans.add(arr[i]);
            i++;
        }

        return ans;
    }
}
