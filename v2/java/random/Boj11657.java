package random;

import java.util.*;
import java.io.*;

public class Boj11657 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int INF = (int) 1e9;
    static ArrayList<ArrayList<int[]>> grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grp = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grp.get(a).add(new int[] { b, c });
        }

        spfa(1);
    }

    static void spfa(int src) {
        long[] dist = new long[N + 1];
        int[] visit = new int[N + 1];
        boolean[] inQ = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, INF);

        q.add(src);
        inQ[src] = true;
        visit[src]++;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            inQ[now] = false;

            for (int[] tmp : grp.get(now)) {
                int next = tmp[0];
                int cost = tmp[1];

                if (dist[next] > dist[now] + cost) {
                    dist[next] = dist[now] + cost;

                    if (!inQ[next]) {
                        q.add(next);
                        inQ[next] = true;
                        visit[next]++;

                        if (visit[next] >= N) {
                            System.out.print(-1);
                            return;
                        }
                    }
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            long k = dist[i] == INF ? -1 : dist[i];
            System.out.println(k);
        }
    }
}
