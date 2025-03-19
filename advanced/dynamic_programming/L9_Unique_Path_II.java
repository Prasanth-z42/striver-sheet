package java_solutions.dynamic_programming;

public class L9_Unique_Path_II {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int n = grid.length;
        int m = grid[0].length;

        uniquePathII(grid, n, m);
    }

    public static void uniquePathII(int[][] grid, int n, int m) {
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
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0;

        int up = f1(i-1, j, grid);
        int left = f1(i, j-1, grid);

        return up + left;
    }

    public static int f2(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int up = f2(i-1, j, grid, dp);
        int left = f2(i, j-1, grid, dp);

        return dp[i][j] = up + left;
    }

    public static int f3(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up += dp[i-1][j];
                    if (j > 0) left += dp[i][j-1];
                    dp[i][j] = up + left;
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
                    curr[j] = 1;
                } else if (grid[i][j] == 1) {
                    curr[j] = 0;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up += prev[j];
                    if (j > 0) left += curr[j-1];
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[m-1];
    }
}
