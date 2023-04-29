package programmers;

import java.util.*;

class Pro17684 {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            lst.add(String.valueOf((char)('A' + i)));
        }

        for (int i = 0; i < msg.length(); i++) {
            String tmp = String.valueOf(msg.charAt(i));
            int j = i + 1;
            String prev = tmp;

            while (j < msg.length() && lst.contains(tmp)) {
                prev = tmp;
                tmp += String.valueOf(msg.charAt(j));
                j++;
            }

            if (!lst.contains(tmp)) {
                lst.add(tmp);
                answer.add(lst.indexOf(prev) + 1);
                i += prev.length() - 1;
            } else {
                answer.add(lst.indexOf(tmp) + 1);
                i += tmp.length() - 1;
            }
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }
}