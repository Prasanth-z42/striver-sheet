package java_solutions.greedy_algorithms;

public class Minimum_No_Of_Platforms {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};

        int ans = minimumNumberOfPlatforms(arr, dep);
        System.out.println(ans);
    }

    public static int minimumNumberOfPlatforms(int[] arr, int[] dep) {
        int n = arr.length;

        int i = 0, j = 0, c = 0, maxC = 0;

        while (i < n) {
            if (arr[i] <= dep[j]) {
                c++;
                i++;
            } else {
                c--;
                j++;
            }
            maxC = Math.max(maxC, c);
        }

        return maxC;
    }
}
