package java_solutions.dynamic_programming;

public class L36_Best_Time_To_Buy_And_Sell_Stock_II {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int n = arr.length;

        int[][] dp = new int[n+1][2];

        // recursive and memoization
        int ans1 = f1(0, 1, arr, n, dp);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(arr, n, dp);
        System.out.println(ans2);

        // space optimization
        int ans3 = f3(arr, n);
        System.out.println(ans3);

        // using 4 variables
        int ans4 = f4(arr);
        System.out.println(ans4);
    }

    public static int f1(int ind, int buy, int[] arr, int n, int[][] dp) {
        if (ind == n) return 0;

        if (dp[ind][buy] != 0) return dp[ind][buy];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[ind] + f1(ind+1, 0, arr, n, dp),
                    f1(ind+1, 1, arr, n, dp));
        else
            profit = Math.max(arr[ind] + f1(ind+1, 1, arr, n, dp),
                    f1(ind+1, 0, arr, n, dp));

        return dp[ind][buy] = profit;
    }

    public static int f2(int[] arr, int n, int[][] dp) {
        dp[n][0] = dp[n][1] = 0;

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1)
                    profit = Math.max(-arr[ind] + dp[ind+1][0],
                            dp[ind+1][1]);
                else
                    profit = Math.max(arr[ind] + dp[ind+1][1],
                            dp[ind+1][0]);

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int f3(int[] arr, int n) {
        int[] dp, curr;
        dp = curr = new int[2];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1)
                    profit = Math.max(-arr[ind] + dp[0],
                            dp[1]);
                else
                    profit = Math.max(arr[ind] + dp[1],
                            dp[0]);

                curr[buy] = profit;
            }
            dp = curr.clone();
        }

        return dp[1];
    }

    public static int f4(int[] arr) {
        int n = arr.length;

        int aheadNotBuy, aheadBuy, currNotBuy, currBuy;
        aheadNotBuy = aheadBuy = currNotBuy = currBuy = 0;

        for (int ind = n-1; ind >= 0; ind--) {
            currBuy = Math.max(-arr[ind] + aheadNotBuy,
                    aheadBuy);
            currNotBuy = Math.max(arr[ind] + aheadBuy,
                    aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }
}
