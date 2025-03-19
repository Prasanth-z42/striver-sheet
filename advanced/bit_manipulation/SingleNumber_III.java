package com.bit_manipulation;
import java.util.Arrays;
public class SingleNumber_III {
    static int[] singleNumbers(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }
        int rightMost = (xor & (xor-1)) ^ xor;
        int b1 = 0, b2 = 0;
        for (int i : arr) {
            if ((i & rightMost) == 1)
                b1 ^= i;
            else
                b2 ^= i;
        }
        return new int[]{b1,b2};
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,3,13,4,1,2,5};
        System.out.println(Arrays.toString(singleNumbers(arr)));
    }
}
