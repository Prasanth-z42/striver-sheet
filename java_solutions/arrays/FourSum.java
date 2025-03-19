package java_solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Similar to 3Sum

    Input: arr = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    Input: arr = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]
 */
public class FourSum {

    // Tc -> O(n log n) + O(n * m * l)
    // Sc -> O(no of unique fours)
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;

            for (int j = i+1; j<n; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while (k<l) {
                    int sum = arr[i] + arr[j] ; // avoids overlap
                    sum += arr[k];
                    sum += arr[l];
                    if (sum < target) k++;
                    else if (sum > target) l--;
                    else {
                        List<Integer> fours = new ArrayList<>();
                        fours.add(arr[i]);
                        fours.add(arr[j]);
                        fours.add(arr[k]);
                        fours.add(arr[l]);
                        ans.add(fours);
                        k++;
                        l--;

                        while (k<l && arr[k] == arr[k-1]) k++;
                        while (k<l && arr[l] == arr[l+1]) l--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;

        int[] arr2 = {2,2,2,2,2};
        int target2 = 8;

        List<List<Integer>> ans = fourSum(arr, target);
        System.out.println(ans);

        ans = fourSum(arr2, target2);
        System.out.println(ans);
    }
}
