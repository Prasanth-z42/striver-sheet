package java_solutions.dynamic_programming;

public class L39_Buy_And_Sell_Stock_With_CoolDown {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,2};
        int n = arr.length;

        // ans = 3 -> b - 1 -> s - 2 --> 1
        //            b - 0 -> s - 2 --> 2  (1 + 2) -> 3

        // same code as dp - 36 or part - 2
        int ans = f(arr, n);
        System.out.println(ans);
    }

    public static int f(int[] arr, int n) {
        int[] after1 = new int[2];
        int[] after2 = new int[2];
        int[] curr = new int[2];

        for (int ind = n-1; ind>=0; ind--) {

            curr[1] = Math.max(-arr[ind] + after1[0],
                    after1[1]);
            curr[0] = Math.max(arr[ind] + after2[1],
                    after1[0]);

            after2 = after1.clone();
            after1 = curr.clone();
        }

        return curr[1];
    }
}
