package com.bit_manipulation;

public class Power_Of_2 {
    public static void main(String[] args) {
        int n = 10;

        if ((n & (n - 1)) == 0) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not");
        }
    }
}
