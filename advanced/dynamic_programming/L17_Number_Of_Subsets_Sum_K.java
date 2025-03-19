package java_solutions.dynamic_programming;
import java.util.Arrays;
public class L17_Number_Of_Subsets_Sum_K {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1};
        int k = 1;
        // {1, 2} {1, 2}, {3}

        numberOfSubsets(arr, k);
    }

    public static void numberOfSubsets(int[] arr, int k) {
        int n = arr.length;
        // Recursive
        int ans1 = f1(n-1, arr, k);
        System.out.println(ans1);

        // Memoization
        int[][] dp = new int[n][k+1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int ans2 = f2(n-1, arr, k, dp);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, arr, k);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, arr, k);
        System.out.println(ans4);
    }

    public static int f1(int ind, int[] arr, int sum) {
        if (ind == 0) {
            if (sum == 0 && arr[ind] == 0) return 2;
            if (sum == 0 || arr[ind] == sum) return 1;
            return 0;
        }

        int np = f1(ind-1, arr, sum);
        int p = 0;
        if (arr[ind] <= sum) p += f1(ind-1, arr, sum - arr[ind]);

        return np + p;
    }

    public static int f2(int ind, int[] arr, int sum, int[][] dp) {
        if (ind == 0) {
            if (sum == 0 && arr[ind] == 0) return 2;
            if (sum == 0 || arr[ind] == sum) return 1;
            return 0;
        }
        if (dp[ind][sum] != -1) return dp[ind][sum];

        int np = f2(ind-1, arr, sum, dp);
        int p = 0;
        if (arr[ind] <= sum) p += f2(ind-1, arr, sum - arr[ind], dp);

        return dp[ind][sum] = np + p;
    }

    public static int f3(int n, int[] arr, int sum) {
        int[][] dp = new int[n][sum+1];

        // Base Case
        if (arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (arr[0] != 0 && arr[0] <= sum) dp[0][arr[0]] = 1;

        for (int ind = 1; ind<n; ind++) {
            for (int tar = 0; tar<=sum; tar++) {
                int np = dp[ind-1][tar];
                int p = 0;
                if (arr[ind] <= tar) p += dp[ind-1][tar - arr[ind]];
                dp[ind][tar] = np + p;
            }
        }

        return dp[n-1][sum];
    }

    public static int f4(int n, int[] arr, int sum) {
        int[] prev = new int[sum+1];

        // Base Case
        if (arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (arr[0] != 0 && arr[0] <= sum) prev[arr[0]] = 1;

        for (int ind = 1; ind<n; ind++) {
            int[] curr = new int[sum+1];
            for (int tar = 0; tar<=sum; tar++) {
                int np = prev[tar];
                int p = 0;
                if (arr[ind] <= tar) p += prev[tar - arr[ind]];
                curr[tar] = np + p;
            }
            prev = curr;
        }

        return prev[sum];
    }
}
