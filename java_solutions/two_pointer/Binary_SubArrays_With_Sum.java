package java_solutions.two_pointer;
/*
    arr = {1, 0, 1, 0, 1};
    goal = 2;
    ans = 4
    // fn(arr, goal) - fn(arr, goal-1)
       (0 + 1 + 2) - (0 + 1)
       3 - 1 = 2
 */
public class Binary_SubArrays_With_Sum {

    // Tc -> O(2n)
    // Sc -> O(1)
    public static int fn(int[] arr, int goal) {
        int n = arr.length;
        int l = 0, r = 0, count = 0;
        int sum = 0;
        while (r < n) {
            sum += arr[r];
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;

        int ans = fn(arr, goal) - fn(arr, goal-1);
        System.out.println(ans);
    }
}
