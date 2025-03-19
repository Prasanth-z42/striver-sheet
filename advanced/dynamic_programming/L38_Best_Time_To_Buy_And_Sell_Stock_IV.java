package java_solutions.dynamic_programming;

public class L38_Best_Time_To_Buy_And_Sell_Stock_IV {
    public static void main(String[] args) {
        // atmost k transactions
        int[] arr = {5, 4, 3, 0, 0, 3, 1, 4};
        int n = arr.length;
        int k = 3;

        // same code as dp - 37
        int ans = f(arr, n, k);
        System.out.println(ans);
    }

    public static int f(int[] arr, int n, int k) {
        int[] next = new int[k*2+1];
        int[] curr = new int[k*2+1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int tran = k*2-1; tran >= 0; tran--) {
                if (tran % 2 == 0) {
                    curr[tran] = Math.max(-arr[ind] + next[tran+1], next[tran]);
                } else {
                    curr[tran] = Math.max(arr[ind] + next[tran+1], next[tran]);
                }
            }
            next = curr.clone();
        }

        return next[0];
    }
}
