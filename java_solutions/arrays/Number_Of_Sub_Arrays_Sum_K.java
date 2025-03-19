package java_solutions.arrays;
/*
    arr = {1, 2, -3, 3, 1, 1, 1, 4, 2, -3}
    res = 7 -> {1, 2}, {1, 2, -3, 3}, {2, -3, 3, 1}, {3}, {1, 1, 1},
               {-3, 3, 1, 1, 1}, {4, 2, -3}
 */
import java.util.HashMap;
import java.util.Map;

public class Number_Of_Sub_Arrays_Sum_K {


    // Tc -> O(n^2) and Sc -> O(1)
    public static int better(int[] arr, int k) {
        int c = 0;
        for (int i = 0; i<arr.length; i++) {
            int sum = 0;
            for (int j = i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == k) c++;
            }
        }

        return c;
    }

    // Hashing
    // Tc -> O(n) and Sc -> O(n) at the worst case
    public static int optimal(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, cnt = 0;

        map.put(0,1);

        for (int i = 0; i<arr.length; i++) {
            preSum += arr[i];
            int rem = preSum - k;

            if (map.containsKey(rem)) {
                cnt += map.get(rem);
            }

            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, 1, 1, 1, 4, 2, -3};
        int k = 3;

        int c1 = better(arr, k);
        int c2 = optimal(arr, k);

        System.out.println(c1);
        System.out.println(c2);
    }

}
