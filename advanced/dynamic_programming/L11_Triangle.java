package java_solutions.dynamic_programming;

public class L11_Triangle {
    public static void main(String[] args) {
        int[][] grid = {
                {1},
                {2, 3},
                {4, 5, 7},
                {8, 6, 9, 10}
        };

        minimumPath(grid);
    }

    public static void minimumPath(int[][] grid) {
        int n = grid.length;
        // Recursive
        int ans1 = f1(0, 0, grid, n);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(0, 0, grid, new int[n][n], n);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(grid, n);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(grid, n);
        System.out.println(ans4);
    }

    public static int f1(int i, int j, int[][] grid, int n) {
        if (i == n-1)
            return grid[i][j];

        int d = grid[i][j] + f1(i+1, j, grid, n);
        int dg = grid[i][j] + f1(i+1, j+1, grid, n);

        return Math.min(d, dg);
    }

    public static int f2(int i, int j, int[][] grid, int[][] dp, int n) {
        if (i == n-1) return grid[i][j];

        if (dp[i][j] != 0) return dp[i][j];

        int d = grid[i][j] + f2(i+1, j, grid, dp, n);
        int dg = grid[i][j] + f2(i+1, j+1, grid, dp, n);

        return dp[i][j] = Math.min(d, dg);
    }

    public static int f3(int[][] grid, int n) {
        int[][] dp = new int[n][n];

        // Base Case
        for (int j = 0; j<n; j++) {
            dp[n-1][j] = grid[n-1][j];
        }

        for (int i = n-2; i>=0; i--) {
            for (int j = i; j>=0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

    public static int f4(int[][] grid, int n) {
        int[] next = new int[n];

        // Base Case
        for (int j = 0; j<n; j++) {
            next[j] = grid[n-1][j];
        }

        for (int i = n-2; i>=0; i--) {
            int[] curr = new int[n];
            for (int j = i; j>=0; j--) {
                curr[j] = grid[i][j] + Math.min(next[j], next[j+1]);
            }
            next = curr;
        }

        return next[0];
    }
}
