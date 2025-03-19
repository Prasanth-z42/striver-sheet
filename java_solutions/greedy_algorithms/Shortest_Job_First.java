package java_solutions.greedy_algorithms;

import java.util.Arrays;

/*
    job = {4, 3, 7, 1, 2}
        // sort [1, 2, 3, 4, 7]
       wt -> 0 -> 1 -> 3 -> 6 -> 10 ---> (0 + 1 + 3 + 6 + 10) = 20
        t -> 1 -> 3 -> 6 -> 10 -> 17

       n = 5, ans = wt / n -> 20 / 5 -> 4
    ans = 4
 */
public class Shortest_Job_First {

    // Tc -> O(n log n) + O(n)
    // Sc -> O(1)
    public static int fn(int[] job) {
        Arrays.sort(job);
        int t = 0, wt = 0;

        for (int i : job) {
            wt += t;
            t += i;
        }

        return wt/job.length;
    }

    public static void main(String[] args) {
        int[] job = {4, 3, 7, 1, 2};

        int ans = fn(job);
        System.out.println(ans);
    }
}
