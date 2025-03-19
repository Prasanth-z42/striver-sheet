package java_solutions.dynamic_programming;

public class L3_Frog_Jump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        frogJump(arr.length, arr);
    }

    public static void frogJump(int n, int[] arr) {
        // Recursion
        int ans1 = f1(n-1, arr);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n-1, arr, new int[n]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, arr);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, arr);
        System.out.println(ans4);
    }

    public static int f1(int ind, int[] arr) {
        if (ind == 0) return 0;

        int one = f1(ind-1, arr) + Math.abs(arr[ind] - arr[ind-1]);
        int two = Integer.MAX_VALUE;
        if (ind > 1)
            two = f1(ind-2, arr) + Math.abs(arr[ind] - arr[ind-2]);

        return Math.min(one, two);
    }

    public static int f2(int ind, int[] arr, int[] dp) {
        if (ind == 0) return 0;

        if (dp[ind] != 0) return dp[ind];

        int one = f2(ind-1, arr, dp) + Math.abs(arr[ind] - arr[ind-1]);
        int two = Integer.MAX_VALUE;
        if (ind > 1)
            two = f2(ind-2, arr, dp) + Math.abs(arr[ind] - arr[ind-2]);

        return dp[ind] = Math.min(one, two);
    }

    public static int f3(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i<n; i++) {
            int one = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int two = Integer.MAX_VALUE;
            if (i > 1) two = dp[i-2] + Math.abs(arr[i] - arr[i-2]);

            dp[i] = Math.min(one, two);
        }

        return dp[n-1];
    }

    public static int f4(int n, int[] arr) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i<n; i++) {
            int one = prev1 + Math.abs(arr[i] - arr[i-1]);
            int two = Integer.MAX_VALUE;
            if (i > 1) two = prev2 + Math.abs(arr[i] - arr[i-2]);

            int curr = Math.min(one, two);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
