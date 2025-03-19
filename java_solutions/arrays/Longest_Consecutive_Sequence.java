package java_solutions.arrays;
/*
    arr = {100, 4, 101, 103, 2, 1, 3}
    res = 4 -> [1, 2, 3, 4]
 */
import java.util.*;

public class Longest_Consecutive_Sequence {

    // Tc -> O(n log n) + O(n)
    // Sc -> O(1)
    public static int method_1(int[] arr) {
        Arrays.sort(arr);
        int lastMin = Integer.MIN_VALUE;
        int c = 0, longer = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i - 1 == lastMin) {
                c++;
                lastMin = i;
            } else if (i != lastMin){
                c = 1;
                lastMin = i;
            }
            longer = Math.max(longer, c);
        }

        return longer;
    }


    // Hashing
    // Tc -> O(n) + O(n * seq)
    // Sc -> O(n)
    public static int method_2(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) set.add(i);

        int longer = Integer.MIN_VALUE;
        for (int i : set) {
            if (!set.contains(i-1)) {
                int c = 1;
                int x = i;
                while (set.contains(x+1)) {
                    x += 1;
                    c++;
                }
                longer = Math.max(longer, c);
            }
        }

        return longer;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 101, 103, 2, 1, 3};

        int res1 = method_1(arr);
        int res2 = method_2(arr);

        System.out.println(res1);
        System.out.println(res2);
    }
}
