package java_solutions.two_pointer;
/*
    arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, k = 2
    ans = 6 -> [0, 0, 1, 1, 1, 1] or [0, 1, 1, 1, 1, 0]
 */
public class Max_Consecutive_Ones_AtMost_K_Zeros {

    // Tc -> O(n)
    // Sc -> O(1)
    public static int fn(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = 0, maxLen = 0;
        int zeros = 0;

        while (r < n) {
            if (arr[r] == 0) zeros++;

            if (zeros > k) {
                if (arr[l] == 0)
                    zeros--;
                l++;
            }

            if (zeros <= k)
                maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int maxOnes = fn(arr, k);
        System.out.println(maxOnes);
    }
}
