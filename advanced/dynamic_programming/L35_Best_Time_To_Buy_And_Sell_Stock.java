package java_solutions.dynamic_programming;

public class L35_Best_Time_To_Buy_And_Sell_Stock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int n = arr.length;

        int ans = f(arr, n);
        System.out.println(ans);
    }

    public static int f(int[] arr, int n) {
        int mini = arr[0];
        int profit = 0;

        for (int i = 1; i<n; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }

        return profit;
    }
}
