package java_solutions.dynamic_programming;

public class L12_MaxOrMin_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 200, 2},
                {1, 2, 2, 1}
        };

        maximumPathSum(grid);
    }

    public static void maximumPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Recursive
        int ans1 = (int)-1e9;
        for (int j = 0; j<m; j++) {
            ans1 = Math.max(ans1, f1(n-1, j, grid, n, m));
        }
        System.out.println(ans1);

        // Memoization
        int ans2 = (int)-1e9;
        for (int j = 0; j<m; j++) {
            ans2 = Math.max(ans2, f2(n-1, j, grid, new int[n][m], n, m));
        }
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(grid, n, m);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(grid, n, m);
        System.out.println(ans4);
    }

    public static int f1(int i, int j, int[][] grid, int n, int m) {
        if (j < 0 || j >= m) return (int)-1e9;
        if (i == 0) return grid[i][j];

        int up = grid[i][j] + f1(i-1, j, grid, n, m);
        int ul = grid[i][j] + f1(i-1, j-1, grid, n, m);
        int ur = grid[i][j] + f1(i-1, j+1, grid, n, m);

        return Math.max(up, Math.max(ul, ur));
    }

    public static int f2(int i, int j, int[][] grid, int[][] dp, int n, int m) {
        if (j < 0 || j >= m) return (int)-1e9;
        if (i == 0) return grid[i][j];
        if (dp[i][j] != 0) return dp[i][j];

        int up = grid[i][j] + f2(i-1, j, grid, dp, n, m);
        int ul = grid[i][j] + f2(i-1, j-1, grid, dp, n, m);
        int ur = grid[i][j] + f2(i-1, j+1, grid, dp, n, m);

        return dp[i][j] = Math.max(up, Math.max(ul, ur));
    }

    public static int f3(int[][] grid, int n, int m) {
        int[][] dp = new int[n][m];

        for (int j = 0; j<m; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i<n; i++) {
            for (int j = 0; j<m; j++) {
                int up = grid[i][j] + dp[i-1][j];
                int ul = grid[i][j];
                if (j > 0) ul += dp[i-1][j-1];
                int ur = grid[i][j];
                if (j+1 < m) ur += dp[i-1][j+1];
                dp[i][j] = Math.max(up, Math.max(ul, ur));
            }
        }

        int maxi = (int)-1e9;
        for (int j = 0; j<m; j++) {
            maxi = Math.max(maxi, dp[n-1][j]);
        }

        return maxi;
    }

    public static int f4(int[][] grid, int n, int m) {
        int[] prev = new int[m];

        for (int j = 0; j<m; j++) {
            prev[j] = grid[0][j];
        }

        for (int i = 1; i<n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j<m; j++) {
                int up = grid[i][j] + prev[j];
                int ul = grid[i][j];
                if (j > 0) ul += prev[j-1];
                int ur = grid[i][j];
                if (j+1 < m) ur += prev[j+1];
                curr[j] = Math.max(up, Math.max(ul, ur));
            }
            prev = curr;
        }

        int maxi = (int)-1e9;
        for (int j = 0; j<m; j++) {
            maxi = Math.max(maxi, prev[j]);
        }

        return maxi;
    }
}
