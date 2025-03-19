package java_solutions.dynamic_programming;

import java.util.Arrays;

public class L50_Burst_Balloons { // balloon
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        // burst = 1 -> 3 * 1 * 5 -> 15
        // burst = 5 -> 3 * 5 * 8 -> 120
        // burst = 3 -> 1 * 3 * 8 -> 24
        // burst = 8 -> 1 * 8 * 1 -> 8

        //       total points -> 167  (Max get) from this way.

        int n = arr.length;
        burstBalloons(arr, n);
    }

    public static void burstBalloons(int[] arr, int n) {
        int[] a = new int[n+2];
        a[0] = a[n+1] = 1;
        for (int i = 1; i<=n; i++) {
            a[i] = arr[i-1];
        }

        // recursion and memoization
        int[][] dp = new int[n+1][n+1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int ans1 = f1(1, n, a, dp);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(a, n);
        System.out.println(ans2);
    }

    public static int f2(int[] arr, int n) {
        int[][] dp = new int[n+2][n+2];

        for (int i = n; i>=1; i--) {
            for (int j = i; j<=n; j++) {

                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[i-1] * arr[ind] * arr[j+1] +
                            dp[i][ind-1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }

    public static int f1(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = arr[i-1] * arr[ind] * arr[j+1] +
                    f1(i, ind-1, arr, dp) + f1(ind + 1, j, arr, dp);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }
}
