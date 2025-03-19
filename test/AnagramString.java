package test;

public class AnagramString {
    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "abab";

        if (f(s1, s2)) System.out.println("YES");
        else System.out.println("NO");

    }


    public static boolean f(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] vis = new int[256];
//        int value = 0;
//
//        for (int i = 0; i < s1.length(); i++) {
//            if (++vis[s1.charAt(i)] == 1) value++;
//            if (--vis[s2.charAt(i)] == -1) value--;
//        }

        for (int i = 0; i<s1.length(); i++) {
            vis[s1.charAt(i)]++;
            vis[s2.charAt(i)]--;
        }

        for (int i : vis) {
            if (i != 0) return false;
        }

        return true;
    }
}

