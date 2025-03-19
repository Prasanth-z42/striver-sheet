package java_solutions.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L44_Longest_Divisible_Subset {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};

        // same code as LIS slightly change
        List<Integer> ans = longestDivisibleSubset(arr);
        System.out.println(ans);
    }

    public static List<Integer> longestDivisibleSubset(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int maxi = 1;
        int lastInd = 0;

        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
                lastInd = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(arr[lastInd]);
        while (hash[lastInd] != lastInd) {
            lastInd = hash[lastInd];
            ans.add(arr[lastInd]);
        }

        Collections.reverse(ans);
        return ans;
    }

}
