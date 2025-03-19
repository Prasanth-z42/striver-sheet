package java_solutions.sorting;

import java.util.*;

public class Sorting_Numbers_By_Frequency {

    public static void freqSort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new FreqSort(map));
        pq.addAll(map.keySet());

        int k = 0;
        while (!pq.isEmpty()) {
            int no = pq.poll();
            for (int i = 0; i<map.get(no); i++) {
                arr[k++] = no;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5, 4, 1, 6, 5, 4, 4, 3, 2};
        freqSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class FreqSort implements Comparator<Integer> {
    private final Map<Integer, Integer> map;
    public FreqSort(Map<Integer, Integer> map) {
        this.map = map;
    }

    public int compare(Integer a, Integer b) {
        int freq = map.get(b) - map.get(a);
        if (freq != 0)
            return freq;
        return Integer.compare(a, b);
    }
}
