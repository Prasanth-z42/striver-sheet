package java_solutions.dynamic_programming;

public class L24_Rod_Cutting_Problem {
    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        int N = 5;

        rodCutting(N, price);
    }

    public static void rodCutting(int N, int[] price) {
        int n = price.length;
        // recursive
        int ans1 = f1(n-1, N, price, new int[n][N+1]);
        System.out.println(ans1);

        // Tabulation
        int ans2 = f2(n, N, price);
        System.out.println(ans2);

        // Space optimization
        int ans3 = f3(n, N, price);
        System.out.println(ans3);
    }

    public static int f1(int ind, int N, int[] price, int[][] dp) {
        if (ind == 0) {
            return N * price[ind];
        }

        if (dp[ind][N] != 0) return dp[ind][N];

        int np = f1(ind-1, N, price, dp);
        int p = 0;
        int rodLen = ind + 1;
        if (rodLen <= N)
            p = price[ind] + f1(ind, N - rodLen, price, dp);

        return dp[ind][N] = Math.max(p, np);
    }

    public static int f2(int n, int maxN, int[] price) {
        int[][] dp = new int[n][maxN+1];
        for (int N = 0; N<=maxN; N++)
            dp[0][N] = N * price[0];

        for (int ind = 1; ind<n; ind++) {
            for (int N = 0; N<=maxN; N++) {
                int np = dp[ind-1][N];
                int p = 0;
                int rodLen = ind+1;
                if (rodLen <= N)
                    p = price[ind] + dp[ind][N - rodLen];

                dp[ind][N] = Math.max(p, np);
            }
        }

        return dp[n-1][maxN];
    }

    public static int f3(int n, int maxN, int[] price) {
        int[] dp = new int[maxN+1];
        for (int N = 0; N<=maxN; N++)
            dp[N] = N * price[0];

        for (int ind = 1; ind<n; ind++) {
            for (int N = ind+1; N<=maxN; N++) {
//                int np = dp[N];
//                int p = 0;
//                int rodLen = ind+1;
//                if (rodLen <= N)
//                    p = price[ind] + dp[N - rodLen];

                dp[N] = Math.max(dp[N], price[ind] + dp[N - (ind+1)]);
            }
        }

        return dp[maxN];
    }
}
