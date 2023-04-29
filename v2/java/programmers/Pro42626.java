package programmers;

import java.util.*;

class Pro42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p1 - p2);
        for (int s : scoville) pq.add(s);

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) return answer;
            if (pq.size() >= 2) {
                pq.add(pq.poll() + (pq.peek() * 2));
                answer++;
                pq.poll();
            } else {
                break;
            }
        }

        return -1;
    }
}
