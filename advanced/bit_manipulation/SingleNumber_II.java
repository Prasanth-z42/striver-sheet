package com.bit_manipulation;
import java.util.Arrays;
public class SingleNumber_II {
    static int m1(int[] arr) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j<arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0)
                    count++;
            }
            if (count % 3 != 0) {
                ans |= (1<<i);
            }
        }
        return ans;
    }
    static int m2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i += 3) {
            if (arr[i] != arr[i-1])
                return arr[i-1];
        }
        return arr[arr.length-1];
    }
    static int m3(int[] arr) {
        int ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++) {
            ones ^= arr[i] & (~(twos));
            twos ^= arr[i] & (~(ones));
        }
        return ones;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,3,3,3,5,5,5};
        System.out.println(m1(arr));
        System.out.println(m2(arr));
        System.out.println(m3(arr));
    }
}
