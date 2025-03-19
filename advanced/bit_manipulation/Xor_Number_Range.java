package com.bit_manipulation;

public class Xor_Number_Range {
    static int xor(int n) {
        if (n % 4 == 0) return n;
        else if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n+1;
        return 0;
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(xor(n));
        // range in two numbers
        int left = 4, right = 7;
        System.out.println(xor(left-1) ^ xor(right));
    }
}
