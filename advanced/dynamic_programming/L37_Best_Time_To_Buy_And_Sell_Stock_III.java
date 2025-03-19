package java_solutions.dynamic_programming;

public class L37_Best_Time_To_Buy_And_Sell_Stock_III {
    public static void main(String[] args) {
        // allow two transactions
        int[] arr = {5, 4, 3, 0, 0, 3, 1, 4};
        int n = arr.length;

        // recursive and memoization
        int[][][] dp = new int[n+1][2][3];
        int ans1 = f1(0, 1, 2, arr, n, dp);
        System.out.println(ans1);

        // tabulation
        int ans2 = f2(arr, n, dp);
        System.out.println(ans2);

        // space optimization
        int ans3 = f3(arr, n);
        System.out.println(ans3);

        // using n * 4 time complexity
        // recursion and memoization
        int ans4 = f4(0, 0, arr, n, new int[n+1][5]);
        System.out.println(ans4);

        // tabulation
        int ans5 = f5(arr, n);
        System.out.println(ans5);

        // space optimization
        int ans6 = f6(arr, n);
        System.out.println(ans6);
    }

    public static int f4(int ind, int tran, int[] arr, int n, int[][] dp) {
        if (ind == n || tran == 4) return 0;
        if (dp[ind][tran] != 0) return dp[ind][tran];
        int profit = 0;
        if (tran % 2 == 0) {
            profit = Math.max(-arr[ind] + f4(ind+1, tran+1, arr, n, dp),
                    f4(ind+1, tran, arr, n, dp));
        } else {
            profit = Math.max(arr[ind] + f4(ind+1, tran+1, arr, n, dp),
                    f4(ind+1, tran, arr, n, dp));
        }

        return dp[ind][tran] = profit;
    }

    public static int f1(int ind, int buy, int cap, int[] arr, int n, int[][][] dp) {

        if (ind == n || cap == 0) return 0;

        if (dp[ind][buy][cap] != 0) return dp[ind][buy][cap];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[ind] + f1(ind+1, 0, cap, arr, n, dp),
                    f1(ind+1, 1, cap, arr, n, dp));
        else
            profit = Math.max(arr[ind] + f1(ind+1, 1, cap-1, arr, n, dp),
                    f1(ind+1, 0, cap, arr, n, dp));

        return dp[ind][buy][cap] = profit;
    }

    public static int f2(int[] arr, int n, int[][][] dp) {
        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-arr[ind] + dp[ind+1][0][cap],
                                dp[ind+1][1][cap]);
                    else
                        profit = Math.max(arr[ind] + dp[ind+1][1][cap-1],
                                dp[ind+1][0][cap]);

                    dp[ind][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public static int f3(int[] arr, int n) {
        int[][] dp = new int[2][3];
        int[][] curr = new int[2][3];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int profit = 0;
                    if (buy == 1)
                        profit = Math.max(-arr[ind] + dp[0][cap],
                                dp[1][cap]);
                    else
                        profit = Math.max(arr[ind] + dp[1][cap-1],
                                dp[0][cap]);

                    curr[buy][cap] = profit;
                }
            }
            dp = curr.clone();
        }

        return dp[1][2];
    }

    public static int f5(int[] arr, int n) {
        int[][] dp = new int[n+1][5];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int tran = 3; tran >= 0; tran--) {
                int profit = 0;
                if (tran % 2 == 0) {
                    profit = Math.max(-arr[ind] + dp[ind+1][tran+1],
                            dp[ind+1][tran]);
                } else {
                    profit = Math.max(arr[ind] + dp[ind+1][tran+1],
                            dp[ind+1][tran]);
                }

                dp[ind][tran] = profit;
            }
        }

        return dp[0][0];
    }

    public static int f6(int[] arr, int n) {
        int[] next = new int[5];
        int[] curr = new int[5];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int tran = 3; tran >= 0; tran--) {
                if (tran % 2 == 0) {
                    curr[tran] = Math.max(-arr[ind] + next[tran+1], next[tran]);
                } else {
                    curr[tran] = Math.max(arr[ind] + next[tran+1], next[tran]);
                }
            }
            next = curr.clone();
        }

        return next[0];
    }
}
