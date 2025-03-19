package java_solutions.dynamic_programming;

public class L5_Maximum_Sum_Non_Adj_Elements {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        maxSumOfNonAdjEle(arr.length, arr);
    }

    public static void maxSumOfNonAdjEle(int n, int[] arr) {
        // Recursive
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
        if (ind == 0) return arr[ind];
        if (ind < 0) return 0;

        int pick = arr[ind] + f1(ind-2, arr);
        int nPick = f1(ind-1, arr);

        return Math.max(pick, nPick);
    }

    public static int f2(int ind, int[] arr, int[] dp) {
        if (ind == 0) return arr[ind];
        if (ind < 0) return 0;
        if (dp[ind] != 0) return dp[ind];

        int pick = arr[ind] + f2(ind-2, arr, dp);
        int nPick = f2(ind - 1, arr, dp);

        return dp[ind] = Math.max(pick, nPick);
    }

    public static int f3(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i<n; i++) {
            int p = arr[i];
            if (i > 1) p += dp[i-2];
            int np = dp[i-1];
            
            dp[i] = Math.max(p, np);
        }

        return dp[n-1];
    }

    public static int f4(int n, int[] arr) {
        int prev1 = arr[0];
        int prev2 = 0;

        for (int i = 1; i<n; i++) {
            int p = arr[i];
            if (i > 1) p += prev2;
            int np = prev1;

            int curr = Math.max(p, np);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
