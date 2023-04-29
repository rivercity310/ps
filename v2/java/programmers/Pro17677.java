package programmers;

import java.util.*;

class Pro17677 {
    Set<String> set = new HashSet<>();

    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = getFragmentedString(str1);
        Map<String, Integer> m2 = getFragmentedString(str2);

        // {"FR":1, "RA":1, "AN":1, "NC":1, "CE":1}
        // {"FR":1, "RE":1, "EN":1, "NC":1, "CH":1}
        // inter = {"FR":1, "NC":1}
        // union = {"FR":2, "RA":1, "AN":1, "NC":2, "CE":1, "RE":1, "EN":1, "CH:1"}

        double inter = 0.0;
        double union = 0.0;

        for (String s : set) {
            union += Math.max(m1.getOrDefault(s, 0), m2.getOrDefault(s, 0));
        }



        for (String s : m1.keySet()) {
            if (m2.containsKey(s)) {
                inter += Math.min(m1.getOrDefault(s, 0), m2.getOrDefault(s, 0));
            }
        }

        if (union == 0.0) return 65536;
        return (int) (inter / union * 65536);
    }

    Map<String, Integer> getFragmentedString(String str) {
        str = str.toUpperCase();
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String tmp = str.substring(i, i + 2);
            char c1 = tmp.charAt(0);
            char c2 = tmp.charAt(1);

            if ((c1 >= 'A' && c1 <= 'Z') && (c2 >= 'A' && c2 <= 'Z')) {
                m.merge(tmp, 1, Integer::sum);
                set.add(tmp);
            }
        }

        return m;
    }
}