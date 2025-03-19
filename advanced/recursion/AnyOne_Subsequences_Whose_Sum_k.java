package com.recursion;

import java.util.*;
public class AnyOne_Subsequences_Whose_Sum_k {
    static boolean f(int ind, int sum, int[] arr, List<List<Integer>> list, List<Integer> ds, int n) {
        if (ind == n) {
            if (sum == 0) {
                list.add(new ArrayList<>(ds));
                return true;
            } else {
                return false;
            }
        }
        ds.add(arr[ind]);
        if(f(ind + 1, sum - arr[ind], arr, list, ds, n))
            return true;
        ds.remove(ds.size()-1);
        return f(ind + 1, sum, arr, list, ds, n);
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = {1,2,1};
        f(0, 5, arr, list, new ArrayList<>(), arr.length);
        System.out.println(list);
    }
}
