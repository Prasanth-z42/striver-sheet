package java_solutions;

public class Dummy {
    public static void main(String[] args) {
        int a = 3, b = 4, c = 5;

        int max = (a > b) ? ((a > c) ? a : b) : ((b < c)? c : b);
        System.out.println(max);
    }
}
