package java_solutions.matrix;

import java.util.Arrays;

public class Check_Each_Row_Rotated_By_1_Element {

    public static boolean check(int[] a, int[] b, int k) {

        k %= a.length;
        reverse(a, 0, a.length-1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);

        for (int i = 0; i<a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean check(int[][] mat, int k) {
        for (int i = 1; i<mat.length; i++) {
            if (!check(mat[i-1], mat[i], k))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {2, 3, 4, 1}
        };

        int k = 3;
        System.out.println(check(mat, k));
    }
}
