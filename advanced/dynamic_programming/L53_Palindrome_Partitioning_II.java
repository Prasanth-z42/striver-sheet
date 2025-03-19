package java_solutions.dynamic_programming;

public class L53_Palindrome_Partitioning_II {
    public static void main(String[] args) {
        String str = "bababcbadcede";
        // find the min partitions need to palindrome string
        // max = str.length()-1 -> bcz, a | a | b | b -> 3 partitions (len -> 4 - 1 -> 3
        //       another way -> a | a | bb -> 2 partitions need
        //       min way ->  aa | bb -> only one partition need

        int n = str.length();
        minPartitions(str, n);
    }

    public static void minPartitions(String str, int n) {
        // recursion and memoization
        Integer[] dp = new Integer[n];
        int ans = f1(0, str, n, dp);
        System.out.println(ans);

        // tabulation
        int ans2 = f2(str, n);
        System.out.println(ans2);
    }

    public static int f2(String str, int n) {
        int[] dp = new int[n+1];

        for (int i = n-1; i>=0; i--) {

            int mini = Integer.MAX_VALUE;
            for (int j = i; j<n; j++) {
                if (isPalindrome(i, j, str)) {
                    int cost = 1 + dp[j+1];
                    mini = Math.min(mini, cost);
                    // dp[i] = Math.min(dp[i], 1 + dp[j+1]);
                }
            }

            dp[i] = mini;
        }

        return dp[0];
    }

    public static int f1(int i, String str, int n, Integer[] dp) {
        if (i == n) return 0;

        if (dp[i] != null) return dp[i];

        int mini = Integer.MAX_VALUE;
        for (int j = i; j<n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + f1(j+1, str, n, dp);
                mini = Math.min(mini, cost);
            }
        }

        return dp[i] = mini;
    }

    public static boolean isPalindrome(int i, int j, String str) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
