package java_solutions.arrays;

import java.util.Arrays;

/*
    type - 1
    arr = {-2, -3, 4, -1, -2, 1, 5, -3}
    ans = 7 -> {4, -1, -2, 1, 5}

    type - 2
    arr = {-2, -3, 4, -1, -2, 1, 5, -3}
    ans = {4, -1, -2, 1, 5}
 */
public class Maximum_SubArray_Sum {

    // Kadane's Algorithm
    // Tc -> O(n) and Sc -> O(1)
    public static int maxSubArray1(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i<arr.length; i++) {
            sum += arr[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0) sum = 0;
        }

        return maxi;
    }

    // Kadane's Algorithm
    // Tc -> O(n) and Sc -> O(max sub arr)

    public static int[] maxSubArray2(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0, start = 0;
        int arrStart = 0, arrEnd = 0;

        for (int i = 0; i<arr.length; i++) {
            if (sum == 0) start = i;

            sum += arr[i];

            if (maxi < sum) {
                maxi = sum;
                arrStart = start;
                arrEnd = i;
            }

            if (sum < 0)
                sum = 0;
        }

        return Arrays.copyOfRange(arr, arrStart, arrEnd+1);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int ans = maxSubArray1(arr);
        int[] res = maxSubArray2(arr);

        System.out.println(ans);
        System.out.println(Arrays.toString(res));
    }
}
