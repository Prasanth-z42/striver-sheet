package java_solutions.dynamic_programming;

public class L16_Partition_Set_Into_two_Subsets_Minimum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7};
        int n = arr.length;


        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        boolean[] prev = new boolean[totalSum+1];

        // Base Cases
        prev[0] = true;

        prev[arr[0]] = true;

        for (int ind = 1; ind<n; ind++) {
            boolean[] curr = new boolean[totalSum+1];
            for (int tar = 1; tar <= totalSum; tar++) {
                boolean np = prev[tar];
                boolean p = false;
                if (tar >= arr[ind]) {
                    p = prev[tar-arr[ind]];
                }

                curr[tar] = p || np;
            }
            prev = curr;
        }

        int mini = (int) 1e9;
        for (int s1 = 0; s1<totalSum/2; s1++) {
            if (prev[s1]) {
                mini = Math.min(mini, Math.abs(totalSum - s1) - s1);
            }
        }

        System.out.println(mini);
    }
}
