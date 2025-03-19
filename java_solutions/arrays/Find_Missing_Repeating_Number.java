package java_solutions.arrays;
/*
    arr = {4, 3, 6, 2, 1, 1}
    ans = [5, 1] or [1, 5]
 */
import java.util.Arrays;

public class Find_Missing_Repeating_Number {

    // Tc -> O(n^2)
    // Sc -> O(2)
    public static int[] brute(int[] arr) {
        int n = arr.length;
        int miss = -1, rep = -1;
        for (int i = 1; i<=n; i++) {

            int c = 0;
            for (int j : arr) {
                if (j == i) c++;
            }

            if (c == 2) rep = i;
            if (c == 0) miss = i;

            if (miss != -1 && rep != -1)
                break;
        }

        return new int[]{miss, rep};
    }

    // Tc -> O(2n)
    // Sc -> O(n+1)
    public static int[] better(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n+1];

        for (int i : arr) {
            freq[i]++;
        }

        int miss = -1, rep = -1;
        for (int i = 1; i<=n; i++) {
            if (freq[i] == 2) rep = i;
            if (freq[i] == 0) miss = i;
        }

        return new int[]{miss, rep};
    }

    // optimal 1 -> Maths
    // Tc -> O(n)
    // Sc -> O(1)
    public static int[] optimal1(int[] arr) {
        int n = arr.length;
        int y = (n * (n+1)) / 2;
        int y2 = (n * (n+1) * (2*n+1)) / 6;

        int x = 0, x2 = 0;

        for (int i : arr) {
            x += i;
            x2 += (i * i);
        }

        int val1 = x - y; // x - y = -4
        int val2 = x2 - y2; // x^2 - y^2 = (x + y) (x - y) = -24

        val2 /= val1;    // x + y = -24 / -4 = 6

        x = (val1 + val2) / 2; // x = -4 + 6 / 2 = 1
        y = x - val1; // x - y = -4, x = 1 -> y = 1 + 4 = 5

        return new int[] {y, x};
    }

    // bitwise operator (xor)
    public static int[] optimal2(int[] arr) {
        int n = arr.length;

        int xr = 0;
        for (int i = 0; i<n; i++) {
            xr ^= arr[i];
            xr ^= (i+1);
        }

        int bitNo = 0;

        while ((xr & (1 << bitNo)) == 0) {
            bitNo++;
        }

        // another way to find the bitNo

        int one = 0, zero = 0;

        for (int i = 0; i<n; i++) {
            if ((arr[i] & (1 << bitNo)) != 0)
                one ^= arr[i];
            else
                zero ^= arr[i];

            if ((i+1 & (1 << bitNo)) != 0)
                one ^= (i+1);
            else
                zero ^= (i+1);
        }

        int c = 0;
        for (int i : arr) {
            if (i == zero) c++;
        }

        if (c == 2) return new int[] {one, zero};
        return new int[] {zero, one};
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 2, 5, 1};

        System.out.println(Arrays.toString(brute(arr)));
        System.out.println(Arrays.toString(better(arr)));
        System.out.println(Arrays.toString(optimal1(arr)));
        System.out.println(Arrays.toString(optimal2(arr)));
    }
}
