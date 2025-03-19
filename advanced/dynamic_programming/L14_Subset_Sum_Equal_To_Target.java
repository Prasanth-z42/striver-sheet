package java_solutions.dynamic_programming;

public class L14_Subset_Sum_Equal_To_Target {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1};
        int k = 5;

        subsetSumEqualToK(arr, k);
    }

    public static void subsetSumEqualToK(int[] arr, int k) {
        int n = arr.length;
        // Recursive
        boolean ans1 = f1(n-1, arr, k);
        System.out.println(ans1);

        // Memoization
        boolean ans2 = f2(n-1, arr, k, new boolean[n][k+1]);
        System.out.println(ans2);

        // Tabulation
        boolean ans3 = f3(n, arr, k);
        System.out.println(ans3);

        // Space Optimization
        boolean ans4 = f4(n, arr, k);
        System.out.println(ans4);
    }

    public static boolean f1(int ind, int[] arr, int tar) {
        if (tar == 0) return true;
        if (ind == 0) return (arr[ind] == tar);

        boolean np = f1(ind-1, arr, tar);
        boolean p = false;
        if (tar >= arr[ind]) {
            p = f1(ind-1, arr, tar-arr[ind]);
        }

        return p || np;
    }

    public static boolean f2(int ind, int[] arr, int tar, boolean[][] dp) {
        if (tar == 0) return true;
        if (ind == 0) return (arr[ind] == tar);

        if (dp[ind][tar]) return true;

        boolean np = f2(ind-1, arr, tar, dp);
        boolean p = false;
        if (tar >= arr[ind]) {
            p = f2(ind-1, arr, tar-arr[ind], dp);
        }

        return dp[ind][tar] = p || np;
    }

    public static boolean f3(int n, int[] arr, int k) {
        boolean[][] dp = new boolean[n][k+1];

        // Base Cases
        for (int i = 0; i<n; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for (int ind = 1; ind<n; ind++) {
            for (int tar = 1; tar <= k; tar++) {
                boolean np = dp[ind-1][tar];
                boolean p = false;
                if (tar >= arr[ind]) {
                    p = dp[ind-1][tar-arr[ind]];
                }

                dp[ind][tar] = p || np;
            }
        }

        return dp[n-1][k];
    }

    public static boolean f4(int n, int[] arr, int k) {
        boolean[] prev = new boolean[k+1];

        // Base Cases
        prev[0] = true;

        prev[arr[0]] = true;

        for (int ind = 1; ind<n; ind++) {
            boolean[] curr = new boolean[k+1];
            for (int tar = 1; tar <= k; tar++) {
                boolean np = prev[tar];
                boolean p = false;
                if (tar >= arr[ind]) {
                    p = prev[tar-arr[ind]];
                }

                curr[tar] = p || np;
            }
            prev = curr;
        }

        return prev[k];
    }
}
