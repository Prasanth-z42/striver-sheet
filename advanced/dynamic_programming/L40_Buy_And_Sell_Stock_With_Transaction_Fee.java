package java_solutions.dynamic_programming;

public class L40_Buy_And_Sell_Stock_With_Transaction_Fee {
    public static void main(String[] args) {
        int[] arr = {1,3,2,8,4,9};
        int fee = 2;

        int ans = f(arr, fee); // same code as part - II
        System.out.println(ans);
    }

    public static int f(int[] arr, int fee) {
        int n = arr.length;

        int currBuy, currNotBuy, aheadBuy, aheadNotBuy;
        currBuy = currNotBuy = aheadBuy = aheadNotBuy = 0;

        for (int ind = n-1; ind>=0; ind--) {

            currBuy = Math.max(-arr[ind] - fee + aheadNotBuy,
                    aheadBuy);
            currNotBuy = Math.max(arr[ind] + aheadBuy,
                    aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }
}
