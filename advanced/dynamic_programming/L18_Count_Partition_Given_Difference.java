package java_solutions.dynamic_programming;
/*
    logic
        s1 = totalSum - s2;
        s1 - s2 = d
        totalSum - s2 - s2 = d
        totalSum -2s2 = d
        2s2 = totalSum - d
        s2 = (totalSum - d) / 2
 */
public class L18_Count_Partition_Given_Difference {
    public static void main(String[] args) {
        // Same code as L17
        int[] arr = {5, 2, 6, 4};
        int d = 3;
        // {5, 2} - {6, 4} = 3 -> true
        // s1 > s2

        System.out.println(countPartitions(arr, d));
    }

    public static int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) return 0;
        return f4(arr.length, arr, (totalSum - diff) / 2);
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
