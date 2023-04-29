package programmers;

import java.util.*;

class Pro17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int num = 0;
        int person = 0;

        while (true) {
            String str = Integer.toString(num, n);
            boolean flag = false;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (person == p - 1) {
                    answer.append(c);

                    if (answer.length() == t) {
                        flag = true;
                        break;
                    }
                }
                person = (person + 1) % m;
            }

            if (flag) break;
            num++;
        }

        return answer.toString();
    }
}