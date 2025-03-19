package java_solutions.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sorting_Characters_By_Frequency {
    public static String freqSort(String str) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : str.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new FrequencyComparator(hm));
        pq.addAll(hm.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = hm.get(ch);
            sb.append(String.valueOf(ch).repeat(Math.max(0, count)));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "zoho";
        str = freqSort(str);
        System.out.println(str);
    }
}
class FrequencyComparator implements Comparator<Character> {
    private final Map<Character, Integer> map;

    public FrequencyComparator(Map<Character, Integer> hm) {
        this.map = hm;
    }

    @Override
    public int compare(Character a, Character b) {
        return map.get(b) - map.get(a);
    }
}