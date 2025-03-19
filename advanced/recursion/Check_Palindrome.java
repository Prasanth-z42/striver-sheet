package java_solutions.recursion;

public class Check_Palindrome {
    public static void main(String[] args) {
        String str = "appa";
        boolean ans = check(0, str, str.length());
        System.out.println(ans);
    }

    public static boolean check(int i, String str, int n) {
        if (i >= n/2) return true;
        return str.charAt(i) == str.charAt(n-i-1) && check(i+1, str, n);
    }
}
