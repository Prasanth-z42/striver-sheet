package java_solutions.arrays;

/*
    type - 1 -> Equal no of pos and neg values
    arr1 = {5,4,-1,2,-7,-10}
    res = {5, -1, 4, -7, 2, -10}

    type - 2 -> Not equal no of pos and neg values
    arr2 = {5,4,-1,2,-7,-10, 2, 5, -11, 15, 18}
    res = {5, -1, 4, -7, 2, -10, 2, -11, 5, 15, 18}
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rearrange_Elements_By_Sign {

    // Tc -> O(n) and Sc -> O(n)
    public static int[] rearrange1(int[] arr) {
        int[] ans = new int[arr.length];
        int pos = 0, neg = 1;

        for (int i : arr) {
            if (i < 0) {
                ans[neg] = i;
                neg += 2;
            } else {
                ans[pos] = i;
                pos += 2;
            }
        }

        return ans;
    }

    // Tc -> O(n) + O(n) + O(2n) = O(4n) and Sc -> O(n)
    public static int[] rearrange2(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i < 0) neg.add(i);
            else pos.add(i);
        }

        int[] ans = new int[pos.size() + neg.size()];

        if (pos.size() > neg.size()) {
            for (int i = 0; i<neg.size(); i++) {
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int ind = neg.size() * 2;
            for (int i = neg.size(); i<pos.size(); i++) {
                ans[ind++] = pos.get(i);
            }
        } else {
            for (int i = 0; i<pos.size(); i++) {
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int ind = pos.size() * 2;
            for (int i = pos.size(); i<neg.size(); i++) {
                ans[ind++] = neg.get(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {5,4,-1,2,-7,-10};
        int[] ans = rearrange1(arr1);
        System.out.println(Arrays.toString(ans));

        int[] arr2 = {5,4,-1,2,-7,-10, 2, 5, -11, 15, 18};
        int[] res = rearrange2(arr2);
        System.out.println(Arrays.toString(res));
    }
}
