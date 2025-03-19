package java_solutions.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        f(0, new ArrayList<>(), arr, target);
    }

    public static void f(int ind, List<Integer> ds, int[] arr, int target) {
        if (ind >= arr.length) {
            if (target == 0) {
                System.out.println(ds);
            }
            return;
        }
        if (target >= arr[ind]) {
            ds.add(arr[ind]);
            f(ind, ds, arr, target - arr[ind]);
            ds.remove(ds.size()-1);
        }
        f(ind+1, ds, arr, target);
    }
}
