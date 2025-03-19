package com.bit_manipulation;

public class Check_Ith_Bit {
    public static void main(String[] args) {
        int n = 4, i = 2;

        // Using left shift operator ( << )
        if ((n & (1 << i)) != 0) {
            System.out.println("Set");
        } else {
            System.out.println("Not");
        }

        // Using right shift operator ( >> )
        if (((n >> i) & 1) == 0) {
            System.out.println("Not");
        } else {
            System.out.println("Set");
        }
    }
}
