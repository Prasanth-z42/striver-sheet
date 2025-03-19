package java_solutions.dynamic_programming;

public class L23_Unbounded_Knapsack {
    public static void main(String[] args) {
        int n = 3, W = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};

        unboundedKnapsack(n, W, profit, weight);
    }

    public static void unboundedKnapsack(int n, int W, int[] profit, int[] weight) {
        // recursive & memoization
        int ans1 = f1(n-1, W, profit, weight, new int[n][W+1]);
        System.out.println(ans1);

        // Tabulation
        int ans2 = f2(n, W, profit, weight);
        System.out.println(ans2);

        // Space optimization
        int ans3 = f3(n, W, profit, weight);
        System.out.println(ans3);
    }

    public static int f1(int ind, int w, int[] profit, int[] weight, int[][] dp) {
        if (ind == 0) {
            return (w / weight[ind]) * profit[ind];
        }
        if (dp[ind][w] != 0) return dp[ind][w];
        int np = f1(ind-1, w, profit, weight, dp);
        int p = 0;
        if (weight[ind] <= w)
            p = profit[ind] + f1(ind, w - weight[ind], profit, weight, dp);

        return dp[ind][w] = Math.max(p, np);
    }

    public static int f2(int n, int W, int[] profit, int[] weight) {
        int[][] dp = new int[n][W+1];
        for (int w = 0; w<=W; w++)
            dp[0][w] = (w/weight[0]) * profit[0];

        for (int ind = 1; ind<n; ind++) {
            for (int w = 0; w<=W; w++) {
                int np = dp[ind-1][w];
                int p = 0;
                if (weight[ind] <= w)
                    p += profit[ind] + dp[ind][w - weight[ind]];

                dp[ind][w] = Math.max(p, np);
            }
        }

        return dp[n-1][W];
    }

    public static int f3(int n, int W, int[] profit, int[] weight) {
        int[] dp = new int[W+1];

        for (int w = 0; w<=W; w++)
            dp[w] = (w/weight[0]) * profit[0];

        for (int ind = 1; ind<n; ind++) {
            for (int w = weight[ind]; w<=W; w++) {
                dp[w] = Math.max(dp[w], profit[ind] + dp[w - weight[ind]]);
            }
        }

        return dp[W];
    }

}
