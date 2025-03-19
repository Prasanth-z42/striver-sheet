package java_solutions.dynamic_programming;

public class L20_Minimum_Coins {
    private static final int maxVal = (int) 1e9;
    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 1};
        int T = 11;

        minimumCoins(arr, T);
    }

    public static void minimumCoins(int[] arr, int T) {
        int n = arr.length;
        // Recursive
        int ans1 = f1(n-1, T, arr);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n-1, T, arr, new int[n][T+1]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, arr, T);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, arr, T);
        System.out.println(ans4);
    }

    public static int f1(int ind, int T, int[] arr) {
        if (ind == 0) {
            if (T % arr[0] == 0) return T / arr[0];
            else return maxVal;
        }

        int np = f1(ind-1, T, arr);
        int p = maxVal;
        if (arr[ind] <= T) p = 1 + f1(ind, T-arr[ind], arr);

        return Math.min(p, np);
    }

    public static int f2(int ind, int T, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0) return T / arr[0];
            else return maxVal;
        }

        if (dp[ind][T] != 0) return dp[ind][T];

        int np = f2(ind-1, T, arr, dp);
        int p = maxVal;
        if (arr[ind] <= T) p = 1 + f2(ind, T-arr[ind], arr, dp);

        return dp[ind][T] = Math.min(p, np);
    }

    public static int f3(int n, int[] arr, int target) {
        int[][] dp = new int[n][target + 1];
        for (int T = 0; T<=target; T++) {
            if (T % arr[0] == 0) dp[0][T] = T / arr[0];
            else dp[0][T] = maxVal;
        }

        for (int ind = 1; ind<n; ind++) {
            for (int T = 0; T<=target; T++) {
                int np = dp[ind-1][T];
                int p = maxVal;
                if (arr[ind] <= T) p = 1 + dp[ind][T-arr[ind]];

                dp[ind][T] = Math.min(p, np);
            }
        }

        return dp[n-1][target];
    }

    public static int f4(int n, int[] arr, int target) {
        int[] dp = new int[target + 1];
        for (int T = 0; T<=target; T++) {
            if (T % arr[0] == 0) dp[T] = T / arr[0];
            else dp[T] = maxVal;
        }

        for (int ind = 1; ind<n; ind++) {
            for (int T = 0; T<=target; T++) {
                int np = dp[T];
                int p = maxVal;
                if (arr[ind] <= T) p = 1 + dp[T-arr[ind]];

                dp[T] = Math.min(p, np);
            }
        }

        return dp[target];
    }
}
