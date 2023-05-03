package programmers;

import java.util.*;

class Pro72411 {
    Map<String, Integer> m;
    boolean[] visited;
    char[] tmp;

    public String[] solution(String[] orders, int[] course) {
        m = new TreeMap<>();

        for (String s : orders) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String order = new String(c);

            for (int slice = 2; slice <= order.length(); slice++) {
                visited = new boolean[order.length()];
                tmp = new char[slice];
                tracking(order, tmp, slice, 0, 0);
            }
        }

        List<String> lst = new ArrayList<>();

        for (int cs : course) {
            int mcall = 0;

            for (String key : m.keySet()) {
                if (key.length() == cs) {
                    mcall = Math.max(m.get(key), mcall);
                }
            }

            if (mcall < 2) continue;

            for (String key : m.keySet()) {
                if (key.length() == cs && m.get(key) == mcall) {
                    lst.add(key);
                }
            }
        }

        Collections.sort(lst);
        String[] answer = new String[lst.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = lst.get(i);

        return answer;
    }

    void tracking(String order, char[] tmp, int slice, int start, int depth) {
        if (depth == slice) {
            m.merge(new String(tmp), 1, Integer::sum);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = order.charAt(i);
                tracking(order, tmp, slice, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
