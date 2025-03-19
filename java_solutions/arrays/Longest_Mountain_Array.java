package java_solutions.arrays;

public class Longest_Mountain_Array {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};

        int ans = longestMountain(arr);  // 1 4 7 3 2
        System.out.println(ans);
    }

    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 1; i<n-1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int left = i-1;
                int right = i+1;

                while (left > 0 && arr[left] > arr[left-1]) left--;
                while (right < n && arr[right] > arr[right+1]) right++;

                longest = Math.max(longest, right - left + 1);
                i = right;
            }
        }

        return longest;
    }
}
