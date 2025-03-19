package java_solutions.dynamic_programming;
import java.util.Arrays;
public class L41_Longest_Increasing_SubSequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int n = arr.length;    // ans -> 4 {2, 3, 7, 101 or 8}

        LIS(arr, n);
    }

    public static void LIS(int[] arr, int n) {
        // recursion and memoization
        int ans1 = f1(0, -1, arr, n, new int[n][n+1]);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(arr, n);
        System.out.println(ans2);

        // space optimization
        int ans3 = f3(arr, n);
        System.out.println(ans3);

        // try to fill dp table dp[n]
        int ans4 = f4(arr, n);
        System.out.println(ans4);
    }

    public static int f4(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (arr[ind] > arr[prev]) {
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }

        return maxi;
    }

    public static int f3(int[] arr, int n) {
        int[] next = new int[n+2];
        int[] curr = new int[n+2];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int prev = ind-1; prev >= -1; prev--) {
                int np = next[prev+1];
                int p = 0;
                if(prev == -1 || arr[ind] > arr[prev])
                    p = 1 + next[ind+1];

                curr[prev+1] = Math.max(np, p);
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static int f2(int[] arr, int n) {
        int[][] dp = new int[n+1][n+2];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int prev = ind-1; prev >= -1; prev--) {
                int np = dp[ind+1][prev+1];
                int p = 0;
                if(prev == -1 || arr[ind] > arr[prev])
                    p = 1 + dp[ind+1][ind+1];

                dp[ind][prev+1] = Math.max(np, p);
            }
        }

        return dp[0][0];
    }

    public static int f1(int ind, int prev, int[] arr, int n, int[][] dp) {
        if (ind == n) return 0;
        if (dp[ind][prev+1] != 0) return dp[ind][prev+1];

        int np = f1(ind+1, prev, arr, n, dp);
        int p = 0;
        if(prev == -1 || arr[ind] > arr[prev])
            p = 1 + f1(ind+1, ind, arr, n, dp);

        return dp[ind][prev+1] = Math.max(np, p);
    }
}
