package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2606 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, cnt;
    static List<Integer>[] grp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        grp = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            grp[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            grp[u].add(v);
            grp[v].add(u);
        }

        solve(1);

        for (int i = 1; i <= N; i++) {
            if (visited[i]) cnt++;
        }

        System.out.println(cnt - 1);
    }

    private static void solve(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : grp[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
