package com.bit_manipulation;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println("Before : " + a + " " + b);
        //Swap
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After : " + a + " " + b);
    }
}
