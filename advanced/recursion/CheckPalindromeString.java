package com.recursion;

public class CheckPalindromeString {
    static boolean check(String str, int i) {
        if(i >= str.length()/2)
            return true;
        if(str.charAt(i) != str.charAt(str.length()-i-1))
            return false;
        return check(str,i+1);
    }
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(check(str,0));
    }
}
