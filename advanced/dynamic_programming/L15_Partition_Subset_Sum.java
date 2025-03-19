package java_solutions.dynamic_programming;

public class L15_Partition_Subset_Sum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;
        // divide two half
        // {2, 3, 5} , {3, 3, 4} equal sum
        boolean ans = partitionSubsetSum(n, arr);
        System.out.println(ans);
    }

    public static boolean partitionSubsetSum(int n, int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) return false;
        return f1(n, arr, sum/2);
    }

    public static boolean f1(int n, int[] arr, int k) {
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
