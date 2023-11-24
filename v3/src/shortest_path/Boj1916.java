package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1916 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, S, D, INF;
    static List<int[]>[] grp;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        INF = Integer.MAX_VALUE;

        grp = new List[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 1; i <= N; i++)
            grp[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            grp[u].add(new int[] { v, w });
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(distance[D]);
    }

    private static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] { S, 0 });
        distance[S] = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int start = p[0];
            int weight = p[1];

            if (distance[start] < weight)
                continue;

            for (int[] next : grp[start]) {
                int dest = next[0];
                int cost = next[1];

                int w = distance[start] + cost;

                if (distance[dest] > w) {
                    distance[dest] = w;
                    pq.add(new int[] { dest, w });
                }
            }
        }
    }
}
