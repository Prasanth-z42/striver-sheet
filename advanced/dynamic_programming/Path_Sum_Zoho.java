package java_solutions.dynamic_programming;

public class Path_Sum_Zoho {
    private static final int minVal = (int)-1e8;
    public static void main(String[] args) {
        int[][] arr = {
                {3, 2, 9},
                {6, 5, 4},
                {7, 8, 1}
        };

        // rightUp, right, rightDown (moves)
        pathSum(arr);
    }

    public static void pathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // Recursive
        int ans1 = minVal;
        for (int i = 0; i<n; i++) {
            ans1 = Math.max(ans1, f1(i, 0, arr, n, m, new int[n][m]));
        }
        System.out.println(ans1);

        // Tabulation
        int ans2 = f3(arr, n, m);
        System.out.println(ans2);

        // Space Optimization
        int ans3 = f4(arr, n, m);
        System.out.println(ans3);
    }

    public static int f1(int i, int j, int[][] arr, int n, int m, int[][] dp) {
        if (i < 0 || i >= n) return minVal;
        if (j == m-1) return arr[i][j];
        if (dp[i][j] != 0) return dp[i][j];

        int ru = arr[i][j] + f1(i-1, j+1, arr, n, m, dp);
        int rr = arr[i][j] + f1(i, j+1, arr, n, m, dp);
        int rd = arr[i][j] + f1(i+1, j+1, arr, n, m, dp);

        return dp[i][j] = Math.max(ru, Math.max(rr, rd));
    }

    public static int f3(int[][] arr, int n, int m) {
        int[][] dp = new int[n][m];

        // Base Case
        for (int i = 0; i<n; i++) {
            dp[i][m-1] = arr[i][m-1];
        }

        for (int j = m-2; j>=0; j--) {
            for (int i = 0; i<n; i++) {
                int ru = 0, rr = 0, rd = 0;

                ru = (i-1 >= 0) ? dp[i-1][j+1] : minVal;
                rr = dp[i][j+1];
                rd = (i+1 < n) ? dp[i+1][j+1] : minVal;

                dp[i][j] = arr[i][j] + Math.max(ru, Math.max(rr, rd));
            }
        }

        int maxi = minVal;
        for (int i = 0; i<n; i++) {
            maxi = Math.max(maxi, dp[i][0]);
        }

        return maxi;
    }

    public static int f4(int[][] arr, int n, int m) {
        int[] prev = new int[n];

        // Base Case
        for (int i = 0; i<n; i++) {
            prev[i] = arr[i][m-1];
        }

        for (int j = m-2; j>=0; j--) {
            int[] curr = new int[n];
            for (int i = 0; i<n; i++) {
                int ru = 0, rr = 0, rd = 0;

                ru = (i-1 >= 0) ? prev[i-1] : minVal;
                rr = prev[i];
                rd = (i+1 < n) ? prev[i+1] : minVal;

                curr[i] = arr[i][j] + Math.max(ru, Math.max(rr, rd));
            }
            prev = curr;
        }

        int maxi = minVal;
        for (int i = 0; i<n; i++) {
            maxi = Math.max(maxi, prev[i]);
        }

        return maxi;
    }
}
