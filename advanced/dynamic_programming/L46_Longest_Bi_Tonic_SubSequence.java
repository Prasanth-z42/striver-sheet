package java_solutions.dynamic_programming;
import java.util.*;
public class L46_Longest_Bi_Tonic_SubSequence {
    public static void main(String[] args) {
        // bi-tonic -> 1. LIS, 2. LDS, 3. LIS - val - LDS

        int[] arr = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};

        int ans = longestBi_tonicSubsequence(arr);
        System.out.println(ans);
    }

    public static int longestBi_tonicSubsequence(int[] arr) {
        int n = arr.length;

        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for (int i = 1; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }


        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for (int i = n-1; i>=0; i--) {
            for (int j = n-1; j>i; j--) {
                if (arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        System.out.println(Arrays.toString(dp2));

        int maxi = 0;
        for (int i = 0; i<n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }
}
