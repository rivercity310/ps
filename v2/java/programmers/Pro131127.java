package programmers;

import java.util.*;

class Pro131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> m = new HashMap<>();

            for (int j = 0; j < want.length; j++) {
                m.put(want[j], number[j]);
            }

            if (chk(m, i, discount)) {
                answer++;
            }
        }

        return answer;
    }

    boolean chk(Map<String, Integer> m, int start, String[] discount) {
        for (int i = start; i < start + 10; i++) {
            String dis = discount[i];

            if (m.containsKey(dis)) {
                int k = m.get(dis);
                if (k > 0) m.put(dis, k - 1);
            }
        }

        for (String key : m.keySet()) {
            if (m.get(key) > 0) return false;
        }

        return true;
    }
}
