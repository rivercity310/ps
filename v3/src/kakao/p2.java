package kakao;

import java.util.*;

public class p2 {
    static List<Integer>[] grp;
    static boolean[] visited;
    static Deque<Integer> dq;
    static int a, b, c;
    static int[] ans;

    public int[] solution(int[][] edges) {
        ans = new int[4];

        // ans[0] = 생성한 정점의 번호
        // ans[1] = 도넛 모양 그래프 개수: (n, n-1), 원래 출발했던 정점으로 돌아옴
        // ans[2] = 막대 모양 그래프 개수: (n, n-1), 모든 정점을 한번씩 방문하게 됨
        // ans[3] = 8자 모양 그래프 개수: (2n+1, 2n+2), 동일한 2개의 도넛 모양 그래프를 결합

        int N = edges.length;
        grp = new List[N + 1];
        dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++)
            grp[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            grp[u].add(v);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);

            while (!dq.isEmpty()) {
                System.out.print(dq.removeFirst() + " ");
            }
            System.out.println();
        }

        return ans;
    }

    static void dfs(int node) {
        visited[node] = true;
        dq.add(node);

        for (int next : grp[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}