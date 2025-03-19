package java_solutions.arrays;

import java.util.Arrays;

/*
    arr1 = {1, 3, 5, 7};
    arr2 = {0, 2, 6, 8, 9};

    ans = {0, 1, 2, 3}
    ans = {5, 6, 7, 8, 9}
 */
public class Merge_Two_Sorted_Arrays {

    // Tc -> O(4n) + O(n+m log n+m)
    // Sc -> O(n+m)
    public static void brute(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] res = new int[n + m];
        int k = 0;

        for (int i : a) {
            res[k++] = i;
        }
        for (int i : b) {
            res[k++] = i;
        }

        Arrays.sort(res);
        k = 0;

        for (int i = 0; i<n; i++) {
            a[i] = res[k++];
        }
        for (int i = 0; i<m; i++) {
            b[i] = res[k++];
        }
    }

    // Tc -> O(m) + O(n log n) + O(m log m)
    // Sc -> O(1)
    public static void better(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int i = n-1;
        int j = 0;

        while (i>=0 && j<m) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    // Gap method
    // Tc -> O(log n+m * m)
    // Sc -> O(1)
    public static void optimal(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int len = n+m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    if (a[left] > b[right-n])
                        swap(a, b, left, right-n);
                } else if (left >= n) {
                    if (b[left-n] > b[right-n])
                        swap(b, b, left-n, right-n);
                } else {
                    if (a[left] > a[right])
                        swap(a, a, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        //brute(arr1, arr2);
        //better(arr1, arr2);
        optimal(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
