package programmers;

import java.util.*;

class Pro42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            dq.addLast(new int[] { i, priorities[i] });
        }

        while (true) {
            int max = 0;
            for (int[] d : dq) max = Math.max(max, d[1]);

            int[] tmp = dq.removeFirst();

            if (tmp[1] == max) {
                answer++;
                if (tmp[0] == location) break;
            }
            else {
                dq.addLast(tmp);
            }
        }

        return answer;
    }
}
