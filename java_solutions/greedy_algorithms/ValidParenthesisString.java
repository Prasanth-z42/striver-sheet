package java_solutions.greedy_algorithms;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String str = "(((**)";
        System.out.println(valid(str));

        boolean ans = dpSolution(str);
        System.out.println(ans);
    }

    public static boolean dpSolution(String str) {
        int min = 0, max = 0;

        for (int i = 0; i<str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == '(') {
                min += 1;
                max += 1;
            } else if (ch == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }

        return min == 0;
    }

    public static boolean valid(String str) {
        return valid(0, str, 0);
    }

    public static boolean valid(int ind, String str, int cnt) {
        if (cnt == -1) return false;
        if (ind == str.length()) return cnt == 0;

        boolean open, close;
        open = close = false;

        if (str.charAt(ind) == '(') {
            open = valid(ind+1, str, cnt+1);
        }
        if (str.charAt(ind) == ')') {
            close = valid(ind+1, str, cnt-1);
        }
        return open || close || valid(ind+1, str, cnt);
    }
}
