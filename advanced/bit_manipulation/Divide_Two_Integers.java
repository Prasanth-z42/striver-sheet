package com.bit_manipulation;

public class Divide_Two_Integers {
    static int divideTwoIntegers(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = true;

        int num = Math.abs(dividend);
        int d = Math.abs(divisor);
        int count = 0;
        int ans = 0;

        while (num >= d) {
            count = 0;
            while (num >= (d << count+1))
                count++;
            ans |= (1<<count);
            num -= (d * (1<<count));
        }

        if (sign)
            return -1 * (ans);
        return ans;
    }
    public static void main(String[] args) {
        int dividend = 2;
        int divisor = 3;
        System.out.println(divideTwoIntegers(dividend,divisor));
    }
}
