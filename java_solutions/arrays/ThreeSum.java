package java_solutions.arrays;
/*
    arr = {-1, 0, 1, 2, -1, -4}  -> (arr[i] + arr[j] + arr[k] == 0)
    ans = [-1, -1, 2], [-1, 0, 1]
 */
import java.util.*;

public class ThreeSum {

    // Tc -> O(n^3)
    // Sc -> O(2 * no of unique triplets)
    public static List<List<Integer>> brute(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                for (int k = j+1; k<n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> tri = new ArrayList<>();
                        tri.add(arr[i]);
                        tri.add(arr[j]);
                        tri.add(arr[k]);
                        Collections.sort(tri);
                        set.add(tri);
                    }
                }
            }
        }


        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // Tc -> O(n*2)
    // Sc -> O(2 * no of unique triplets)
    public static List<List<Integer>> better(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i<n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i+1; j<n; j++) {
                int third = -(arr[i] + arr[j]);
                if (hashSet.contains(third)) {
                    List<Integer> tri = new ArrayList<>();
                    tri.add(arr[i]);
                    tri.add(arr[j]);
                    tri.add(third);
                    Collections.sort(tri);
                    set.add(tri);
                }
                hashSet.add(arr[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // Tc -> O(n log n) + O(n*m)
    // Sc -> O(no of unique triplets)
    public static List<List<Integer>> optimal(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            if (i > 0 && arr[i] == arr[i-1])
                continue;
            int j = i+1;
            int k = n-1;

            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> tri = new ArrayList<>();
                    tri.add(arr[i]);
                    tri.add(arr[j]);
                    tri.add(arr[k]);
                    ans.add(tri);
                    j++;
                    k--;

                    while (j<k && arr[j] == arr[j-1]) j++;
                    while (j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans1 = brute(arr);
        System.out.println(ans1);

        List<List<Integer>> ans2 = better(arr);
        System.out.println(ans2);

        List<List<Integer>> ans3 = optimal(arr);
        System.out.println(ans3);
    }
}
