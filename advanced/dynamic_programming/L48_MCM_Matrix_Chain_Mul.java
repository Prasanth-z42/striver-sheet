package java_solutions.dynamic_programming;

import java.util.Arrays;

public class L48_MCM_Matrix_Chain_Mul {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 25};
        int n = arr.length;

        // no of dimensions of n-1 matrix  n-1 where n = 4
        // assume abcd matrices
        // a -> 10 * 20
        // b -> 20 * 30
        // c -> 30 * 40
        // d -> 40 * 50
        // find the minimum no of operations need to multiply them (abcd)

        mcm(arr, n);
    }

    public static void mcm(int[] arr, int n) {
        // recursion and memoization
        int[][] dp = new int[n][n];
        for (int[] i : dp) Arrays.fill(i, -1);
        int ans1 = f1(1, n-1, arr, n, dp);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(arr, n);
        System.out.println(ans2);
    }

    public static int f2(int[] arr, int n) {
        int[][] dp = new int[n][n];
        // no need to fill base case because default value is 0

        for (int i = n-1; i>=1; i--) {
            for (int j = i+1; j<=n-1; j++) {
                if (i == j) continue;
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind < j; ind++) {
                    int steps = arr[i-1] * arr[ind] * arr[j] +
                            dp[i][ind] + dp[ind+1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][n-1];
    }

    public static int f1(int i, int j, int[] arr, int n, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind < j; ind++) {
            int steps = arr[i-1] * arr[ind] * arr[j] +
                        f1(i, ind, arr, n, dp) + f1(ind+1, j, arr, n, dp);
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;
    }
}
