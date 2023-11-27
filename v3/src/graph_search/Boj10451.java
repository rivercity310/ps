package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10451 {
    static BufferedReader br;
    static StringTokenizer st;
    static int T, N;
    static boolean[] visited;
    static StringBuffer sb;
    static List<Integer>[] grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            grp = new List[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++)
                grp[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                int e = Integer.parseInt(st.nextToken());
                grp[i].add(e);
            }

            solve();
        }

        System.out.print(sb);
    }

    private static void solve() {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        sb.append(cnt).append('\n');
        Deque<Integer> dq = new ArrayDeque<>();
        dq.peekFirst() dq.peekL
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : grp[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
