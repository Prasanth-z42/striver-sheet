package java_solutions.dynamic_programming;

public class L10_Minimum_Path_Sum {
    private static final int maxVal = (int) Math.pow(10, 9);
    public static void main(String[] args) {
        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int n = grid.length;
        int m = grid[0].length;

        minimumPathSum(grid, n, m);
    }

    public static void minimumPathSum(int[][] grid, int n, int m) {
        // Recursive
        int ans1 = f1(n-1, m-1, grid);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n-1, m-1, grid, new int[n][m]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, m, grid);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, m, grid);
        System.out.println(ans4);
    }

    public static int f1(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return maxVal;

        int up = grid[i][j] + f1(i-1, j, grid);
        int left = grid[i][j] + f1(i, j-1, grid);

        return Math.min(up, left);
    }

    public static int f2(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return maxVal;
        if (dp[i][j] != 0) return dp[i][j];

        int up = grid[i][j] + f2(i-1, j, grid, dp);
        int left = grid[i][j] + f2(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public static int f3(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = maxVal, left = maxVal;
                    if (i > 0) up = grid[i][j] + dp[i-1][j];
                    if (j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static int f4(int n, int m, int[][] grid) {
        int[] prev = new int[m];
        for (int i = 0; i<n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j<m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = maxVal, left = maxVal;
                    if (i > 0) up = grid[i][j] + prev[j];
                    if (j > 0) left = grid[i][j] + curr[j-1];
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[m-1];
    }
}
