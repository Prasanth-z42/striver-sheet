package java_solutions.arrays;

import java.util.ArrayList;
import java.util.List;

/*
    input -> row = 6
    output -> 1 5 10 10 5 1

    formula ->  ans * (row - col) / col
 */
public class Pascal_Triangle_2 {


    // Tc -> O(n) and Sc -> O(row.size())
    public static List<Integer> findPasTri(int n) {
        List<Integer> ans = new ArrayList<>();
        int res = 1;
        ans.add(res);

        for (int i = 1; i<n; i++) {
            res = res * (n - i) / i;
            ans.add(res);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        List<Integer> ans = findPasTri(n);
        System.out.println(ans);
    }
}
