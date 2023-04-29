package programmers;

import java.util.*;

class Pro17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int num = 0;
        int person = 0;

        while (true) {
            String str = getNumStr(n, num);
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

    // k의 n진법 수를 반환
    String getNumStr(int n, int k) {
        StringBuilder sb = new StringBuilder();

        if (k == 0) return "0";

        while (k > 0) {
            int a = k % n;
            if (a < 10) sb.append(a);
            else sb.append(String.valueOf((char)('A' + (a - 10))));
            k /= n;
        }

        return sb.reverse().toString();
    }
}