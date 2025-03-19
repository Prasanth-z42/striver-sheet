package java_solutions.dynamic_programming;

import java.lang.management.MemoryType;
import java.util.Arrays;

public class L49_Minimum_Cost_To_Cut_A_Stick {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int k = 7;  // length of the stick
        int n = arr.length;

        minimumCostToCutAStick(arr, k, n);
    }

    public static void minimumCostToCutAStick(int[] arr, int k, int n) {
        // add 0 and k to the array
        arr = Arrays.copyOf(arr, n+2);
        arr[n] = 0;
        arr[n+1] = k;
        Arrays.sort(arr);

        // recursion and memoization
        int[][] dp = new int[n+1][n+1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int ans1 = f1(1, n, arr, dp);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(arr, n, k);
        System.out.println(ans2);
    }

    public static int f2(int[] arr, int n, int k) {
        int[][] dp = new int[n+2][n+2];

        for (int i = n; i>=1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[j+1] - arr[i-1] +
                            dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][n];
    }

    public static int f1(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = arr[j+1] - arr[i-1] +
                    f1(i, ind-1, arr, dp) + f1(ind+1, j, arr, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }
}
