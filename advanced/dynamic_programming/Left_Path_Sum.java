package java_solutions.dynamic_programming;

public class Left_Path_Sum {
    private static final int maxi = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] arr = {
                {3, 2, 9},
                {6, 5, 4},
                {7, 8, 1}
        };

        pathSum(arr);
    }

    public static void pathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // Recursive
        int ans1 = maxi;
        for (int i = 0; i<n; i++) {
            ans1 = Math.min(ans1, f1(i, m-1, arr, n, new int[n][m]));
        }
        System.out.println(ans1);

        // Tabulation
        int ans2 = f3(n, m, arr);
        System.out.println(ans2);

        // Space Optimization
        int ans3 = f4(n, m, arr);
        System.out.println(ans3);
    }

    public static int f1(int i, int j, int[][] arr, int n, int[][] dp) {
        if (i < 0 || i >= n) return maxi;
        if (j == 0) return arr[i][j];
        if (dp[i][j] != 0) return dp[i][j];

        int lu = f1(i-1, j-1, arr, n, dp);     // left up
        int ll = f1(i, j-1, arr, n, dp);
        int ld = f1(i+1, j-1, arr, n, dp);    // left down

        return dp[i][j] = arr[i][j] + Math.min(lu, Math.min(ll, ld));
    }

    public static int f3(int n, int m, int[][] arr) {
        int[][] dp = new int[n][m];

        for (int i = 0; i<n; i++) {
            dp[i][0] = arr[i][0];
        }

        for (int j = 1; j<m; j++) {
            for (int i = 0; i<n; i++) {
                int lu = (i-1 >= 0) ? dp[i-1][j-1] : maxi;
                int ll = dp[i][j-1];
                int ld = (i+1 < n) ? dp[i+1][j-1] : maxi;

                dp[i][j] = arr[i][j] + Math.min(lu, Math.min(ll, ld));
            }
        }

        int mini = maxi;
        for (int i = 0; i<n; i++) {
            mini = Math.min(mini, dp[i][m-1]);
        }

        return mini;
    }

    public static int f4(int n, int m, int[][] arr) {
        int[] prev = new int[n];

        for (int i = 0; i<n; i++) {
            prev[i] = arr[i][0];
        }

        for (int j = 1; j<m; j++) {
            int[] curr = new int[n];
            for (int i = 0; i<n; i++) {
                int lu = (i-1 >= 0) ? prev[i-1] : maxi;
                int ll = prev[i];
                int ld = (i+1 < n) ? prev[i+1] : maxi;

                curr[i] = arr[i][j] + Math.min(lu, Math.min(ll, ld));
            }
            prev = curr;
        }

        int mini = maxi;
        for (int i = 0; i<n; i++) {
            mini = Math.min(mini, prev[i]);
        }

        return mini;
    }
}
