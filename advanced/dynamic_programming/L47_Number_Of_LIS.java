package java_solutions.dynamic_programming;
import java.util.Arrays;
public class L47_Number_Of_LIS {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 6};
        int n = arr.length;
        // ans -> 2 --->  1, 3, 4, 7  and 1, 3, 5, 7

        int ans = f(n, arr);
        System.out.println(ans);
    }

    public static int f(int n, int[] arr) {
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int i = 0; i<n; i++) {
            cnt[i] = 1;
            for (int j = 0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi, cnt[i]);
        }

        int ans = 0;
        for (int i = 0; i<n; i++) {
            if (dp[i] == maxi) ans += cnt[i];
        }

        return ans;
    }
}
