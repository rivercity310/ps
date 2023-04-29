package programmers;

import java.util.*;

class Pro87946 {
    int[] od;
    boolean[] visited;
    int answer;

    public int solution(int k, int[][] dungeons) {
        od = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        computeOrders(0, dungeons.length, k, dungeons);

        return answer;
    }

    // (0 ~ 던전 개수 - 1) 순열 구하기
    void computeOrders(int depth, int N, int k, int[][] dungeons) {
        if (depth == N) {
            int cnt = 0;

            for (int o : od) {
                int least = dungeons[o][0];
                int p = dungeons[o][1];

                if (k >= least) {
                    k -= p;
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);

            return;
        }

        for (int i = 0; i < od.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                od[depth] = i;
                computeOrders(depth + 1, N, k, dungeons);
                od[depth] = 0;
                visited[i] = false;
            }
        }
    }
}
