package java_solutions.arrays;

import java.util.ArrayList;
import java.util.List;

/*
    input -> 5
    output ->     1
                 1 1
                1 2 1
               1 3 3 1
              1 4 6 4 1
 */
public class Pascal_Triangle_3 {

    // Tc -> O(n * r)
    // Sc -> O(n * r)
    public static List<List<Integer>> pascalTriangle(int n, List<List<Integer>> ans) {
        for (int i = 1; i<=n; i++) {
            List<Integer> row = new ArrayList<>();
            int res = 1;
            row.add(res);

            for (int j = 1; j<i; j++) {
                res = res * (i-j) / j;
                row.add(res);
            }

            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;

        List<List<Integer>> ans = new ArrayList<>();
        pascalTriangle(n, ans);

        for (List<Integer> l : ans)
            System.out.println(l);
    }
}
