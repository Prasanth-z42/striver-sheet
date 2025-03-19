package java_solutions.arrays;

import java.util.Arrays;

public class Sorting_Colors {

    // Tc -> O(n log n) and Sc -> O(1)
    public static int[] brute(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // Tc -> O(2n) and Sc -> O(1)
    public static int[] better(int[] arr) {
        int zeros = 0, ones = 0, twos = 0;

        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == 0) zeros++;
            else if (arr[i] == 1) ones++;
            else twos++;
        }

        int k = 0;
        for (int i = 0; i<zeros; i++) arr[k++] = 0;
        for (int i = 0; i<ones; i++) arr[k++] = 1;
        for (int i = 0; i<twos; i++) arr[k++] = 2;

        return arr;
    }

    // "Dutch National Flag Algorithm"
    // Tc -> O(n) and Sc -> O(1)
    public static int[] optimal(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

        return arr;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 0, 1, 2};

        // int[] m1 = brute(arr);
        // System.out.println(Arrays.toString(m1));

        // int[] m2 = better(arr);
        // System.out.println(Arrays.toString(m2));

        int[] m3 = optimal(arr);
        System.out.println(Arrays.toString(m3));
    }
}
