package java_solutions.dynamic_programming;

public class L13_Cherry_PickUp_II {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        cherryPickup(grid);
    }

    public static void cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Recursive
        int ans1 = f1(0, 0, m-1, grid, n, m);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(0, 0, m-1, grid, n, m, new int[n][m][m]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(grid, n, m);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(grid, n, m);
        System.out.println(ans4);
    }

    public static int f1(int i, int j1, int j2, int[][] grid, int n, int m) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int)-1e8;
        if (i == n-1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi = (int)-1e8;
        for (int dj1 = -1; dj1<2; dj1++) {
            for (int dj2 = -1; dj2<2; dj2++) {
                int value = 0;

                if (j1 == j2) value += grid[i][j1];
                else value += grid[i][j1] + grid[i][j2];

                value += f1(i+1, j1+dj1, j2+dj2, grid, n, m);
                maxi = Math.max(maxi, value);
            }
        }

        return maxi;
    }

    public static int f2(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int)-1e8;
        if (i == n-1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != 0) return dp[i][j1][j2];

        int maxi = (int)-1e8;
        for (int dj1 = -1; dj1<2; dj1++) {
            for (int dj2 = -1; dj2<2; dj2++) {
                int value = 0;

                if (j1 == j2) value += grid[i][j1];
                else value += grid[i][j1] + grid[i][j2];

                value += f2(i+1, j1+dj1, j2+dj2, grid, n, m, dp);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }

    public static int f3(int[][] grid, int n, int m) {
        int[][][] dp = new int[n][m][m];

        // Base Case
        for (int j1 = 0; j1<m; j1++) {
            for (int j2 = 0; j2<m; j2++) {
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // Express stuffs int the for loops
        for (int i = n-2; i>=0; i--) {
            for (int j1 = 0; j1<m; j1++) {
                for (int j2 = 0; j2<m; j2++) {

                    int maxi = (int)-1e8;
                    for (int dj1 = -1; dj1<2; dj1++) {
                        for (int dj2 = -1; dj2<2; dj2++) {
                            int value = 0;

                            if (j1 == j2) value += grid[i][j1];
                            else value += grid[i][j1] + grid[i][j2];

                            if (j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                value += dp[i+1][j1+dj1][j2+dj2];
                            else value += (int)-1e8;

                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }

    public static int f4(int[][] grid, int n, int m) {
        int[][] next = new int[m][m];

        // Base Case
        for (int j1 = 0; j1<m; j1++) {
            for (int j2 = 0; j2<m; j2++) {
                if (j1 == j2) next[j1][j2] = grid[n-1][j1];
                else next[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // Express stuffs in the for loops
        for (int i = n-2; i>=0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1<m; j1++) {
                for (int j2 = 0; j2<m; j2++) {

                    int maxi = (int)-1e8;
                    for (int dj1 = -1; dj1<2; dj1++) {
                        for (int dj2 = -1; dj2<2; dj2++) {
                            int value = 0;

                            if (j1 == j2) value += grid[i][j1];
                            else value += grid[i][j1] + grid[i][j2];

                            if (j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                value += next[j1+dj1][j2+dj2];
                            else value += (int)-1e8;

                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            next = curr;
        }

        return next[0][m-1];
    }
}
