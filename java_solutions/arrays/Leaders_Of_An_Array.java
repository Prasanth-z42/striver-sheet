package java_solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    arr = {10, 22, 12, 3, 0, 6}
    res = {22, 12, 6}
 */
public class Leaders_Of_An_Array {

    // Tc -> O(n) and Sc -> O(no of leaders in an array)
    public static int[] leadersOfArray(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int max = arr[n-1];
        ans.add(max);
        for (int i = n-2; i>=0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                ans.add(max);
            }
        }

        return reverse(ans.stream().mapToInt(Integer::intValue).toArray());
    }

    public static int[] reverse(int[] arr) {
        int i = 0, j = arr.length-1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        int[] ans = leadersOfArray(arr);
        System.out.println(Arrays.toString(ans));
    }

}
