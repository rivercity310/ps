package part5.graph;

import java.util.*;
import java.io.*;

public class Boj1697 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, max;
    static ArrayList<ArrayList<Integer>> grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Math.max(N, M) * 2;

        grp = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i <= max; i++) {
            grp.get(i).add(i - 1);
            grp.get(i).add(i + 1);
            grp.get(i).add(i * 2);
        }

        if (N == M) System.out.println(0);
        else System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[max];
        int[] dist = new int[max];
        Arrays.fill(dist, (int)1e9);

        q.add(N);
        visited[N] = true;
        dist[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : grp.get(now)) {
                if (next < 0 || next >= max) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);

                    if (dist[next] >= dist[now] + 1) {
                        dist[next] = dist[now] + 1;
                    }
                }
            }
        }

        return dist[M];
    }
}
