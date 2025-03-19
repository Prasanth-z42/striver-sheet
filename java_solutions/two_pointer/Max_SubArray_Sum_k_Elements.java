package java_solutions.two_pointer;
/*
    arr = {-1, 2, 3, 3, 4, 5, 10}
    ans = 22 -> [3, 4, 5, 10]
 */
public class Max_SubArray_Sum_k_Elements {

    // Tc -> O(n-k * k)
    // Sc -> O(1)
    public static int brute(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<=n-k; i++) {
            int sum = 0;
            for (int j = i; j<i+k; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    // Tc -> O(n)
    // Sc -> O(1)

    public static int optimal(int[] arr, int k) {
        int n = arr.length;

        if (k > n) return 0;

        int sum = arr[0];
        for (int i = 1; i<k; i++) sum += arr[i];

        int l = 0, r = k;
        int max = Integer.MIN_VALUE;
        while (r<n) {
            sum -= arr[l];
            l++;
            sum += arr[r];
            r++;
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 3, 4, 5, 10};
        int k = 4;

        int sum1 = brute(arr, k);
        int sum2 = optimal(arr, k);

        System.out.println(sum1);
        System.out.println(sum2);
    }
}
