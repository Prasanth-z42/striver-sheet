package java_solutions.arrays;

import java.util.ArrayList;
import java.util.List;

public class Reverse_Pairs {

    // Tc -> O(n*n)
    // Sc -> O(1)
    public static int better(int[] a) {
        int n = a.length;
        int c = 0;

        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (a[i] > 2*a[j])
                    c++;
            }
        }

        return c;
    }

    // Tc -> O(n log n)
    // Sc -> O(1)
    public static int optimal(int[] a) {
        return mergeSort(a, 0, a.length-1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int r = mid+1;

        for (int i = low; i<=mid; i++) {
            while (r <= high && arr[i] > 2*arr[r]) r++;
            count += (r - (mid + 1));
        }

        return count;
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low, right = mid+1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i<=high; i++) {
            arr[i] = temp.get(i-low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 13, 21, 25, 1, 2, 3, 4, 4, 5, 9, 11, 13};

        int cnt1 = better(arr);
        int cnt2 = optimal(arr);

        System.out.println(cnt1);
        System.out.println(cnt2);
    }
}
