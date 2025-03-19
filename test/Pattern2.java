package test;

public class Pattern2 {
    public static void main(String[] args) {

        int n = 5;
        int start = 1, count = 0;

        for (int i = 0; i<n; i++) {
            int t = start;

            for (int j = 0; j<n; j++) {
                if (j<n-i-1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + t + " ");
                    t = t - count;
                    count++;
                }
            }
            start += (n - i);
            count = (n-1) - i;

            System.out.println();
        }
    }
}
