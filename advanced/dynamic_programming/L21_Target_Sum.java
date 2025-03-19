package java_solutions.dynamic_programming;

public class L21_Target_Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};  // Assign ( + , - )
        int d = 3;

        // {-1 +2 +3 -1} -> 3
        // {+1 -2 +3 +1} -> 3        // 2 ways

        targetSum(arr, d);
    }

    public static void targetSum(int[] arr, int d) {
        int totalSum = 0;
        for (int i : arr) totalSum += i;
        /*   s1 - s2 = d          totalSum = s1 + s2;
             s1 = totalSum - s2;
             d = totalSum - s2 - s2;
             d = totalSum - 2s2;
             2s2 = totalSum - d
             s2 = (totalSum - d) / 2;
        * */
        int n = arr.length;
        int target = (totalSum - d) / 2;

        // recursive and memoization
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
            if (T == 0 && arr[ind] == 0) return 2;
            if (T == 0 || arr[ind] == T) return 1;
            return 0;
        }

        if (dp[ind][T] != 0) return dp[ind][T];

        int np = f1(ind-1, T, arr, dp);
        int p = 0;
        if (arr[ind] <= T) p = f1(ind-1, T-arr[ind], arr, dp);

        return dp[ind][T] = p + np;
    }

    public static int f2(int n, int target, int[] arr) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i<n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target) dp[0][arr[0]] = 1;
        if (arr[0] == 0) dp[0][arr[0]] = 2;

        for (int ind = 1; ind<n; ind++) {
            for (int T = 0; T<=target; T++) {
                int np = dp[ind-1][T];
                int p = 0;
                if (arr[ind] <= T) p = dp[ind-1][T-arr[ind]];

                dp[ind][T] = p + np;
            }
        }

        return dp[n-1][target];
    }

    public static int f3(int n, int target, int[] arr) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        if (arr[0] <= target) dp[arr[0]] = 1;
        if (arr[0] == 0) dp[arr[0]] = 2;

        for (int ind = 1; ind<n; ind++) {
            for (int T = target; T>=0; T--) {
                int np = dp[T];
                int p = 0;
                if (arr[ind] <= T) p = dp[T-arr[ind]];

                dp[T] = p + np;
            }
        }

        return dp[target];
    }
}
