package java_solutions.dynamic_programming;

public class L4_Frog_Jum_With_K_Distance {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int k = 2;
        frogJump2(arr.length, arr, k);
    }

    public static void frogJump2(int n, int[] arr, int k) {
        // Recursive
        int ans1 = f1(n-1, arr, k);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n-1, arr, new int[n], k);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, arr, k);
        System.out.println(ans3);
    }

    public static int f1(int ind, int[] arr, int k) {
        if (ind == 0) return 0;

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i<=k; i++) {
            if (ind - i >= 0) {
                int jump = f1(ind-i, arr, k) + Math.abs(arr[ind] - arr[ind-i]);
                mini = Math.min(mini, jump);
            }
        }

        return mini;
    }

    public static int f2(int ind, int[] arr, int[] dp, int k) {
        if (ind == 0) return 0;

        if (dp[ind] != 0) return dp[ind];

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i<=k; i++) {
            if (ind - i >= 0) {
                int jump = f2(ind-i, arr, dp, k) + Math.abs(arr[ind] - arr[ind-i]);
                mini = Math.min(mini, jump);
            }
        }

        return dp[ind] = mini;
    }

    public static int f3(int n, int[] arr, int k) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i<n; i++) {
            int mini = Integer.MAX_VALUE;
            for (int j = 1; j<=k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    mini = Math.min(mini, jump);
                }
            }
            dp[i] = mini;
        }

        return dp[n-1];
    }
}
