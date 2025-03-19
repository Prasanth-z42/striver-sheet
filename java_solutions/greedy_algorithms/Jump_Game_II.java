package java_solutions.greedy_algorithms;
/*
    arr = {2, 3, 1, 4, 1, 1, 1, 2}
    ans = 3 -> (2 -> 1 -> 4 -> 2)
 */
public class Jump_Game_II {

    // Tc -> O(n^n)
    // Sc -> O(1)
    public static int fn(int ind, int jumps, int[] arr) {
        if (ind >= arr.length-1) return jumps;

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i<=arr[ind]; i++) {
            mini = Math.min(mini, fn(ind+i, jumps+1, arr));
        }

        return mini;
    }

    // Tc -> O(n)
    // Sc -> O(1)
    public static int fn(int[] arr) {
        int l = 0, r = 0, n = arr.length;
        int jumps = 0;

        while (r < n-1) {
            int farthest = 0;
            for (int i = l; i<=r; i++) {
                farthest = Math.max(farthest, i+arr[i]);
            }
            l = r + 1;
            r = farthest;
            jumps += 1;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 1, 1, 1, 2};

        int minJumps = fn(0, 0, arr);
        int minJump = fn(arr);

        System.out.println(minJumps +" jumps to reach end...");
        System.out.println(minJump);
    }
}
