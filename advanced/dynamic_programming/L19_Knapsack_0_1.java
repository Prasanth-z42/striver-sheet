package java_solutions.dynamic_programming;

public class L19_Knapsack_0_1 {
    private static final int minVal = (int) -1e9;
    public static void main(String[] args) {
        int n = 3, maxWeight = 6;
        int[] wt = {3, 2, 5};
        int[] val = {30, 40, 60};

        knapsack(n, maxWeight, wt, val);
    }

    public static void knapsack(int n, int maxWeight, int[] wt, int[] val) {
        // Recursive
        int ans1 = f1(n-1, maxWeight, wt, val);
        System.out.println(ans1);

        // Memoization
        int[][] dp = new int[n][maxWeight+1];
        int ans2 = f2(n-1, maxWeight, wt, val, dp);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, maxWeight, wt, val, dp);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, maxWeight, wt, val, dp);
        System.out.println(ans4);
    }

    public static int f1(int ind, int W, int[] wt, int[] val) {
        if (ind == 0) {
            if (wt[ind] <= W) return val[ind];
            return minVal;
        }

        int np = f1(ind-1, W, wt, val);
        int p = minVal;
        if (wt[ind] <= W) p = val[ind] + f1(ind-1, W-wt[ind], wt, val);

        return Math.max(p, np);
    }

    public static int f2(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (wt[ind] <= W) return val[ind];
            return minVal;
        }

        if (dp[ind][W] != 0 ) return dp[ind][W];

        int np = f2(ind-1, W, wt, val, dp);
        int p = minVal;
        if (wt[ind] <= W) p = val[ind] + f2(ind-1, W-wt[ind], wt, val, dp);

        return dp[ind][W] = Math.max(p, np);
    }

    public static int f3(int n, int maxWeight, int[] wt, int[] val, int[][] dp) {
        for (int i = wt[0]; i<=maxWeight; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind<n; ind++) {
            for (int W = wt[ind]; W <= maxWeight; W++) {
                int np = dp[ind-1][W];
                int p = minVal;
                if (wt[ind] <= W) p = val[ind] + dp[ind-1][W-wt[ind]];

                dp[ind][W] = Math.max(p, np);
            }
        }

        return dp[n-1][maxWeight];
    }

    public static int f4(int n, int maxWeight, int[] wt, int[] val, int[][] dp) {
        int[] prev = new int[maxWeight+1];

        for (int i = wt[0]; i<=maxWeight; i++) {
            prev[i] = val[0];
        }

        for (int ind = 1; ind<n; ind++) {
            for (int W = maxWeight; W >= wt[ind]; W--) {
                int np = prev[W];
                int p = minVal;
                if (wt[ind] <= W) p = val[ind] + prev[W-wt[ind]];

                prev[W] = Math.max(p, np);
            }
        }

        return prev[maxWeight];
    }
}
