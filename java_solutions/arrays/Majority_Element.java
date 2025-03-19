package java_solutions.arrays;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {

    // Hashing
    // Tc -> O(n) + O(no of ele) and Sc -> O(no of ele)
    public static int method_1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int n = arr.length;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > n/2)
                return m.getKey();
        }

        return -1;
    }

    // Moore's Voting Algorithm
    // Tc -> O(n) and Sc -> O(1)
    public static int method_2(int[] arr) {
        int no = arr[0];
        int c = 0;

        for (int i : arr) {
            if (no == i)
                c++;
            else {
                c--;
                if (c == 0) {
                    c = 1;
                    no = i;
                }
            }
        }

        return no;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

        int maj1 = method_1(arr);
        int maj2 = method_2(arr);

        System.out.println(maj1);
        System.out.println(maj2);
    }
}
