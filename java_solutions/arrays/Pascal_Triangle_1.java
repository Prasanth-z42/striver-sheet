package java_solutions.arrays;
/*
    input -> row = 5, col = 3
                                   1
                                  1 1
                                 1 2 1
                                1 3 3 1
                               1 4 6 4 1
    output -> 6

    formula :
            find ncr :  n = row-1, r = col-1
                -> NCR = N! / R! * (N-R)!

            Eg -> row = 5 -> n = 4, col = 3 -> r = 2
                 4C2 = 4! / 2! * 2!
                     = 4*3 * 2! / 2! * 2!
                     = 4 * 3 / 1 * 2
                     = 12 / 2
                     = 6
 */

public class Pascal_Triangle_1 {

    // Tc -> O(col-1)
    // Sc -> O(1)
    public static int findNcr(int n, int r) {

        int res = 1;

        for (int i = 0; i<r; i++) {
            res *= (n-i);
            res /= (i+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int row = 5, col = 3;
        int ans = findNcr(row-1, col-1);
        System.out.println(ans);
    }
}
