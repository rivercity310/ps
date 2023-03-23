package part1;

import java.util.*;

public class Boj1919 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.next();
        String second = scan.next();

        Map<Character, Integer> map1 = getCounterMap(first);
        Map<Character, Integer> map2 = getCounterMap(second);

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            int a = map1.get(c) == null ? 0 : map1.get(c);
            int b = map2.get(c) == null ? 0 : map2.get(c);
            ans += Math.abs(a - b);
        }

        System.out.println(ans);
        scan.close();
    }

    private static Map<Character, Integer> getCounterMap(String str) {
        Map<Character, Integer> m = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            m.merge(c, 1, Integer::sum);
        }

        return m;
    }
}
