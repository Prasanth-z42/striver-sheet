package java_solutions.dynamic_programming;

public class L52_Evaluate_Boolean_Expression_To_True {
    private static final int mod = 1000000007;
    public static void main(String[] args) {
        String exp = "T|F&T";

        evaluateExpression(exp);
    }

    public static void evaluateExpression(String exp) {
        int n = exp.length();

        // recursion and memoization
        Long[][][] dp = new Long[n][n][2];
        long ans = f1(0, n-1, 1, exp, dp);
        System.out.println(ans);

        // tabulation
        long ans2 = f2(exp, n);
        System.out.println(ans2);
    }

    public static long f2(String exp, int n) {
        Long[][][] dp = new Long[n][n][2];

        for (int i = n-1; i>=0; i--) {
            for (int j = i; j<=n-1; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    if (i == j) {
                        if (isTrue == 1) dp[i][j][isTrue] = (long) (exp.charAt(i) == 'T'? 1 : 0);
                        else dp[i][j][isTrue] = (long) (exp.charAt(i) == 'F'? 1 : 0);
                        continue;
                    }

                    long ways = 0;
                    for (int ind = i+1; ind <= j-1; ind += 2) {
                        long lT = dp[i][ind-1][1];
                        long lF = dp[i][ind-1][0];
                        long rT = dp[ind + 1][j][1];
                        long rF = dp[ind + 1][j][0];

                        char operator = exp.charAt(ind);
                        if (operator == '&') {
                            if (isTrue == 1)
                                ways = (ways + (lT * rT) % mod) % mod;
                            else
                                ways = (ways + (lT * rF) % mod + (lF * rT) % mod + (lF * rF) % mod) % mod;
                        } else if (operator == '|') {
                            if (isTrue == 1)
                                ways = (ways + (lT * rF) % mod + (lT * rT) % mod + (lF * rT) % mod) % mod;
                            else
                                ways = (ways + (lF * rF) % mod) % mod;
                        } else {
                            if (isTrue == 1)
                                ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
                            else
                                ways = (ways + (lT * rT) % mod + (lF * rF) % mod) % mod;
                        }
                    }

                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][n-1][1];
    }

    public static long f1(int i, int j, int isTrue, String exp, Long[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) return exp.charAt(i) == 'T'? 1 : 0;
            return exp.charAt(i) == 'F'? 1 : 0;
        }

        if (dp[i][j][isTrue] != null) return dp[i][j][isTrue];

        long ways = 0;
        for (int ind = i+1; ind <= j-1; ind += 2) {
            long lT = f1(i, ind-1, 1, exp, dp);
            long lF = f1(i, ind-1, 0, exp, dp);
            long rT = f1(ind + 1, j, 1, exp, dp);
            long rF = f1(ind + 1, j, 0, exp, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1)
                    ways = (ways + (lT * rT) % mod) % mod;
                else
                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod + (lF * rF) % mod) % mod;
            } else if (operator == '|') {
                if (isTrue == 1)
                    ways = (ways + (lT * rF) % mod + (lT * rT) % mod + (lF * rT) % mod) % mod;
                else
                    ways = (ways + (lF * rF) % mod) % mod;
            } else {
                if (isTrue == 1)
                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
                else
                    ways = (ways + (lT * rT) % mod + (lF * rF) % mod) % mod;
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}
