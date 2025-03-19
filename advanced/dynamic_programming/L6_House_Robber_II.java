package java_solutions.dynamic_programming;
import java.util.Arrays;

public class L6_House_Robber_II {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        int n = arr.length;

        int ans = Math.max(f4(Arrays.copyOfRange(arr, 1, n)), f4(Arrays.copyOfRange(arr, 0, n-1)));
        System.out.println(ans);
    }

    // Maximum Sum of Non Adj Elements
    public static int f4(int[] arr) {
        int n = arr.length;
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
