package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 트리의 부모 찾기 */
public class Boj11725 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static List<ArrayList<Integer>> grp;

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        grp = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grp.get(a).add(b);
            grp.get(b).add(a);
        }

        dfs(1);

        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int node) {
        for (int next : grp.get(node)) {
            if (parent[next] == 0) {
                parent[next] = node;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
}
