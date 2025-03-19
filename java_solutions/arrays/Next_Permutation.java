package java_solutions.arrays;
/*
    arr = {1, 2, 3}
    res = {1, 3, 2}

    arr = {2, 1, 5, 4, 3, 0, 0}
    res = {2, 3, 0, 0, 1, 4, 5}
 */
import java.util.Arrays;

public class Next_Permutation {

    // Tc -> O(n) and Sc -> O(1)
    public static int[] nextPermutation(int[] arr, int n) {

        // step - 1 -> Find the index (breakpoint) during backward traversal where an element is smaller than the
        //             next one.  arr[i]<arr[i+1]
        int ind = -1;
        for(int i = n-2; i>=0; i--) {
            if (arr[i] < arr[i+1]) {
                ind = i;
                break;
            }
        }

        // If ind equals -1(ind == -1), reverse the array and return
        if (ind == -1) {
            reverse(arr, 0, n-1);
            return arr;
        }

        // step - 2 -> find an element such that arr[ind] < arr[i], but select the smallest one during
        //             backward traversal of the array and swap
        for (int i = n-1; i>=0; i--) {
            if (arr[ind] < arr[i]) {
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        // step - 3 -> reverse the array from (index + 1, n-1)
        reverse(arr, ind+1, n-1);

        return arr;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        int n = arr.length;

        arr = nextPermutation(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
