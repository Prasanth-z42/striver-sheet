package java_solutions.greedy_algorithms;
/*
    Leetcode -> 860

    bills = {5, 5, 5, 10, 20}
    ans = true
 */
public class Lemonade_Change {

    // Tc -> O(n)
    // Sc -> O(1)
    public static boolean fn(int[] bills) {
        int five = 0, ten = 0;

        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                if (five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (five >= 3) {
                    five -= 3;
                } else if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};

        boolean ans = fn(bills);
        System.out.println(ans);
    }
}
