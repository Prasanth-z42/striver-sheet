package test;
import java.util.*;

public class directory {
    public static String simplify(String path)
    {

        String[] arr = new String[100];
        int k = 0;
        int n = path.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            String dir = "";

            while (i < n && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;
            }

            if (dir.equals("..")) {
                if (k > 0)
                {
                    arr[k-1] = "";
                    k--;
                }
            }
            else if (dir.equals(".") || dir.equals("")) {
            }
            else {
                arr[k++] = dir;
            }
        }

        for(int i = 0; i<k; i++) {
            ans += "/" + arr[i];
        }

        if (ans == "")
            return "/";

        return ans;
    }

    public static void main(String[] args) {
        String str = "/animal/./box/../../cat/";
        String str2 = "/a/./b/./////c/./d/";

        String res = simplify(str);
        String res2 = simplify(str2);

        System.out.println(res);
        System.out.println(res2);
    }
}

