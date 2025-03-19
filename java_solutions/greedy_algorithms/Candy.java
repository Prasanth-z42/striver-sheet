package java_solutions.greedy_algorithms;
/*
    candy = {0, 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0}
    ans = 27

    candy = {1, 2, 3}
    ans = 6
 */
public class Candy {
    public static void main(String[] args) {
        int[] candy = {0, 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0};

        int ans = f(candy);
        System.out.println(ans);
    }

    public static int f(int[] arr) {
        int n = arr.length;

        int[] a = new int[n];
        a[0] = 1;

        // left pass
        int i = 1;
        while (i < n) {
            if (arr[i-1] < arr[i]) {
                a[i] = a[i-1] + 1;
            } else {
                a[i] = 1;
            }
            i++;
        }

        // right pass
        int j = n-2;
        while (j >= 0) {
            if (arr[j] > arr[j+1]) {
                a[j] = Math.max(a[j], a[j + 1] + 1);
            }
            j--;
        }

        // calculate the candies
        int candies = 0;
        for (int candy : a) {
            candies += candy;
        }

        return candies;
    }
}
