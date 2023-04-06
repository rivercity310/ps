package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1504 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int max = 20_000_000;
    static List<List<int[]>> grp;
    static StringTokenizer st;
    static int[] distance;
    static int N, E;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        grp = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grp.get(a).add(new int[] { b, c });
            grp.get(b).add(new int[] { a, c });
        }

        st = new StringTokenizer(br.readLine());
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> n
        // 1 -> v2 -> v1 -> n
        // 둘 중 작은 값을 구한다
        int res1 = solve(1, V1) + solve(V1, V2) + solve(V2, N);
        int res2 = solve(1, V2) + solve(V2, V1) + solve(V1, N);
        int ans = (res1 >= max && res2 >= max) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    static int solve(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, max);

        pq.offer(new int[] { start, 0 });
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int now = node[0];

            if (!visited[now]) visited[now] = true;
            else continue;

            for (int[] tmp : grp.get(now)) {
                int next = tmp[0];
                int weight = tmp[1];
                int cost = distance[now] + weight;

                if (!visited[next] && distance[next] > cost) {
                    distance[next] = cost;
                    pq.offer(new int[] { next, cost });
                    visited[next] = true;
                }
            }
        }

        return distance[end];
    }
}
