package java_solutions.dynamic_programming;

public class L7_Ninjas_Training {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 50, 1},
                {5, 100, 11}
        };

        int n = arr.length;

        ninjasTraining(arr, n);
    }

    public static void ninjasTraining(int[][] arr, int n) {
        // Recursive
        int ans1 = f1(n-1, 3, arr);
        System.out.println(ans1);

        // Memoization
        int ans2 = f2(n-1, 3, arr, new int[n][4]);
        System.out.println(ans2);

        // Tabulation
        int ans3 = f3(n, arr);
        System.out.println(ans3);

        // Space Optimization
        int ans4 = f4(n, arr);
        System.out.println(ans4);
    }

    public static int f1(int day, int last, int[][] arr) {
        if (day == 0) {

            int maxi = 0;
            for (int task = 0; task<3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[day][task]);
                }
            }

            return maxi;
        }

        int maxi = 0;

        for (int task = 0; task<3; task++) {
            if (task != last) {
                int point = arr[day][task] + f1(day-1, task, arr);
                maxi = Math.max(maxi, point);
            }
        }

        return maxi;
    }

    public static int f2(int day, int last, int[][] arr, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task<3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[day][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != 0) return dp[day][last];
        int maxi = 0;

        for (int task = 0; task<3; task++) {
            if (task != last) {
                int point = arr[day][task] + f2(day-1, task, arr, dp);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[day][last] = maxi;
    }

    public static int f3(int n, int[][] arr) {
        int[][] dp = new int[n][4];

        // Base case
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day<n; day++) {
            for (int last = 0; last<4; last++) {
                for (int task = 0; task<3; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(dp[day][last], arr[day][task] + dp[day-1][task]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    public static int f4(int n, int[][] arr) {
        int[] prev = new int[4];

        // Base case
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day<n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last<4; last++) {
                for (int task = 0; task<3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], arr[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }
}
