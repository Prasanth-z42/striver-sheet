package java_solutions.greedy_algorithms;
/*
    arr1 = {2, 3, 1, 0, 4};
    ans = true --> 2 -> 3 -> 4

    arr2 = {2, 3, 1, 0, 0, 6};
    ans = false --> 2 -> 3 -> 0 or 2 -> 1 -> 0 (doesn't reach)
 */
public class Jump_Game {

    // Tc -> O(n)
    // Sc -> O(1)
    public static boolean fn(int[] arr) {
        int n = arr.length;
        int ind = 0;

        for (int i = 0; i<n; i++) {
            if (i > ind) return false;
            ind = Math.max(ind, (i + arr[i]));
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 0, 4};  // 2 -> 3 -> 4
        int[] arr2 = {2, 3, 1, 0, 0, 6}; // 2 -> 3 -> 0 or 2 -> 1 -> 0 (doesn't reach)

        boolean ans1 = fn(arr1);
        boolean ans2 = fn(arr2);

        System.out.println("Possible -> " + ans1);
        System.out.println("Possible -> " + ans2);
    }
}
