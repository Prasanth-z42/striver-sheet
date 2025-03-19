package java_solutions.two_pointer;
/*
    arr = {1, 2, 3, 6, 5, 6, 1} -> Collect left k cards and right k cards
    ans = 12 -> {5, 6, 1}
 */
public class Max_Points_You_Can_Obtain_From_Cards {

    // Tc -> O(k) + O(k) -> O(2k)
    // Sc -> O(1)
    public static int fn(int[] arr, int k) {
        int lSum = 0, rSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i<k; i++)
            lSum += arr[i];

        maxSum = lSum;

        int r = arr.length-1;
        for (int l = k-1; l>=0; l--) {
            lSum -= arr[l];
            rSum += arr[r--];
            maxSum = Math.max(maxSum, lSum+rSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 5, 6, 1};
        int k = 3;

        int sum = fn(arr, k);
        System.out.println(sum);
    }
}
