package java_solutions.dynamic_programming;
import java.util.*;
public class L42_Print_LCS {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 4, 7, 6};
        int n = arr.length;

        printLCS(arr, n);
    }

    public static void printLCS(int[] arr, int n) {
        int[] dp = new int[n+1];
        int[] hash = new int[n+1];
        Arrays.fill(dp, 1);

        int lastInd = 0;
        int maxi = 1;

        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for (int prev = 0; prev < ind; prev++) {
                if (arr[ind] > arr[prev] &&
                        dp[ind] < 1 + dp[prev]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }

            if (maxi < dp[ind]) {
                maxi = dp[ind];
                lastInd = ind;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(arr[lastInd]);
        while (hash[lastInd] != lastInd) {
            lastInd = hash[lastInd];
            ans.add(arr[lastInd]);
        }

        Collections.reverse(ans);
        System.out.println(ans);
    }
}
