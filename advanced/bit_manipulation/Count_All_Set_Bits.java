package com.bit_manipulation;

public class Count_All_Set_Bits {
    public static void main(String[] args) {
        int n = 10;
        int count = 0;
//        while (n > 0) {
//            count += (n&1);
//            n >>= 1;
//        }
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        System.out.println(count);
    }
}
