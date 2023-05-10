package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<ArrayList<Integer>> grp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        grp = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grp.get(a).add(b);
            grp.get(b).add(a);
        }

        solve();
    }

    static void solve() {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : grp.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
