package com.bit_manipulation;

public class Toggle_Ith_Bit {
    public static void main(String[] args) {
        int n = 13, i = 1;

        int ans = n ^ (1 << i);
        System.out.println(ans);
    }
}
