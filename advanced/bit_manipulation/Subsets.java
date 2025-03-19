package com.bit_manipulation;
import java.util.List;
import java.util.ArrayList;
public class Subsets {
    static List<List<Integer>> subsets(int[] arr, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int num = 0; num < Math.pow(2,n); num++) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0)
                    ds.add(arr[i]);
            }
            ans.add(ds);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        List<List<Integer>> ans = subsets(arr, n);
        System.out.println(ans);
    }
}
