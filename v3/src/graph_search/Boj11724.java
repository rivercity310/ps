package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11724 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, cnt;
    static List<Integer>[] grp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                solve(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void solve(int node) {
        visited[node] = true;

        for (int next : grp[node]) {
            if (!visited[next]) {
                solve(next);
            }
        }
    }
}
