package java_solutions.arrays;

import java.util.ArrayList;
import java.util.List;

public class Count_Inversions {

    // Tc -> O(n^2)
    // Sc -> O(1)
    public static int brute(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (arr[i] > arr[j])
                    cnt++;
            }
        }

        return cnt;
    }

    // Tc -> O(n log n)
    // Sc -> O(1)
    public static int optimal(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                cnt += (mid - left + 1);
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
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        int c1 = brute(arr);
        int c2 = optimal(arr);

        System.out.println(c1);
        System.out.println(c2);
    }
}
