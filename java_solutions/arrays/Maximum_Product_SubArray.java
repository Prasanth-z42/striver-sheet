package java_solutions.arrays;

public class Maximum_Product_SubArray {

    // Tc -> O(n^2)
    // Sc -> O(1)
    public static int brute(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i<n; i++) {
            int pro = 1;
            for (int j = i; j<n; j++) {
                pro *= arr[j];
                max = Math.max(max, pro);
            }
        }

        return max;
    }

    // Tc -> O(n/2)
    // Sc -> O(1)
    public static int optimal(int[] arr) {
        int n = arr.length;
        int pre = 1, suf = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i<n; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre *= arr[i];
            suf *= arr[n-i-1];
            max = Math.max(max, Math.max(pre, suf));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};

        int ans1 = brute(arr);
        System.out.println(ans1);

        int ans2 = optimal(arr);
        System.out.println(ans2);
    }
}
