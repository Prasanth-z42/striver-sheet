package java_solutions.dynamic_programming;

import java.util.Arrays;

public class L54_Partition_Array_Maximum_Sum {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;

        /*
            here k -> 3 -> maxLen of sub array len 3
            Eg :  ->  1 15 | 7 9 2 | 5 10
              max -> 15 15 | 9 9 9 | 10 10
              add -> 30 + 27 + 20 -> 77

            Eg :  -> 1 15 7 | 9 | 2 5 10
              max -> 15 15 15 | 9 | 10 10 10
              add -> 45 + 9 + 30 -> 84

              ans -> 84 (maximum)
         */

        solve(arr, k);
    }

    public static void solve(int[] arr, int k) {
        int n = arr.length;
        // recursion and memoization
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = f1(0, arr, k, n, dp);
        System.out.println(ans);
        
        // tabulation
        int ans2 = f2(arr, k, n);
        System.out.println(ans2);
    }
    
    public static int f2(int[] arr, int k, int n) {
        int[] dp = new int[n+1];

        for (int i = n-1; i>=0; i--) {
            int maxi = Integer.MIN_VALUE;
            int maxSum = 0;
            for (int j = i; j<n && j<i+k; j++) {
                maxi = Math.max(maxi, arr[j]);
                int sum = (j - i + 1) * maxi + dp[j + 1];
                maxSum = Math.max(maxSum, sum);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }

    public static int f1(int i, int[] arr, int k, int n, int[] dp) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];

        int maxi = Integer.MIN_VALUE;
        int maxSum = 0;
        for (int j = i; j<n && j<i+k; j++) {
            maxi = Math.max(maxi, arr[j]);
            int sum = (j - i + 1) * maxi + f1(j + 1, arr, k, n, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }
}
