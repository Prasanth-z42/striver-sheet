package com.bit_manipulation;

public class Set_Ith_Bit {
    public static void main(String[] args) {
        int n = 4, i = 1;

        int ans = n | (i << 1);
        System.out.println(n + " " + ans);
    }
}
