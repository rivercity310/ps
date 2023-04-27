package programmers;

import java.util.ArrayList;
import java.util.List;

public class Pro64065 {

    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int a = 0;
            int cnt = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!(c >= '0' && c <= '9')) break;

                if (a != 0) a *= 10;
                int k = c - '0';
                a += k;
                cnt++;
            }

            if (cnt != 0) {
                // a가 이미 존재하면 a의 갯수를 늘려준다
                // a가 존재하지 않으면 단순 삽입한다

                boolean flag = false;
                int idx = -1;

                for (int c = 0; c < list.size(); c++) {
                    int[] tmp = list.get(c);
                    if (tmp[0] == a) {
                        flag = true;
                        idx = c;
                        break;
                    }
                }

                if (flag) list.get(idx)[1]++;
                else list.add(new int[] { a, 1 });
            }

            i += cnt;
        }

        list.sort((o1, o2) -> o2[1] - o1[1]);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i)[0];
        }

        return answer;
    }
}
