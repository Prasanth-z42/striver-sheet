package com.bit_manipulation;

public class Remove_Last_Bit {
    public static void main(String[] args) {
        int n = 40;

        int ans = n & n-1;
        System.out.println(ans);
    }
}
