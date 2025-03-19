package java_solutions.dynamic_programming;

public class L22_Coin_Change_II {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;
        // how many ways to collect coins for the given target
        // (1, 1, 1, 1), (1, 3), (2, 2), (1, 1, 2)  // ans = 4

        coinChange(arr, target);
    }

    public static void coinChange(int[] arr, int target) {
        int n = arr.length;
        // recursive
        int ans1 = f1(n-1, target, arr, new int[n][target+1]);
        System.out.println(ans1);
        
        // Tabulation
        int ans2 = f2(n, target, arr);
        System.out.println(ans2);

        // Space Optimization
        int ans3 = f3(n, target, arr);
        System.out.println(ans3);
    }

    public static int f1(int ind, int T, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0) return 1;
            return 0;
        }

        if (dp[ind][T] != 0) return dp[ind][T];

        int np = f1(ind-1, T, arr, dp);
        int p = 0;
        if (arr[ind] <= T) p = f1(ind, T-arr[ind], arr, dp);

        return dp[ind][T] = p + np;
    }
    
    public static int f2(int n, int target, int[] arr) {
        int[][] dp = new int[n][target+1];
        for(int T = 0; T<=target; T++) {
            if (T % arr[0] == 0) dp[0][T] = 1;
        }

        for (int ind = 1; ind<n; ind++) {
            for (int T = 0; T<=target; T++) {
                int np = dp[ind-1][T];
                int p = 0;
                if (arr[ind] <= T) p = dp[ind][T-arr[ind]];

                dp[ind][T] = p + np;
            }
        }

        return dp[n-1][target];
    }

    public static int f3(int n, int target, int[] arr) {
        int[] dp = new int[target+1];


        dp[0] = 1;

        for (int ind = 0; ind<n; ind++) {
            for (int T = arr[ind]; T<=target; T++) {
//                int np = dp[T];
//                int p = 0;
//                if (arr[ind] <= T) p = dp[T-arr[ind]];
                dp[T] += dp[T-arr[ind]];
            }
        }

        return dp[target];
    }
}
