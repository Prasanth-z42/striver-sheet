package java_solutions.arrays;
/*
    -> More than n/2 times
    arr = {1, 1, 1, 2, 3, 3, 3}
    ans = [1, 3]
 */
import java.util.*;

public class Majority_Element_II {

    // Hashing
    // Tc -> O(2n) + searching map
    // Sc -> O(no of elements)
    public static List<Integer> majorityElement(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() >= n/2)
                ans.add(m.getKey());
        }

        return ans;
    }

    // Moore's Voting Algorithm
    // Tc -> O(2n)
    // Sc -> O(2)
    public static int[] majorityElement(int[] arr) {
        int ele1 = 0, ele2 = 0, c1 = 0, c2 = 0;

        for (int i : arr) {
            if (i == ele1) {
                c1++;
            } else if (i == ele2) {
                c2++;
            } else if (c1 == 0) {
                ele1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                ele2 = i;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int i : arr) {
            if (i == ele1) c1++;
            else if (i == ele2) c2++;
        }

        int n = arr.length/2;

        int[] ans = new int[2];

        if (c1 >= n) ans[0] = ele1;
        if (c2 >= n) ans[1] = ele2;

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3};
        List<Integer> ans1 = majorityElement(arr, arr.length);
        int[] ans2 = majorityElement(arr);
        System.out.println(ans1);
        System.out.println(Arrays.toString(ans2));
    }
}
