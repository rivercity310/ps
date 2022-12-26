package boj.Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11438 {
    static final int LOG = 21;
    static int N, M;
    static List<Integer>[] tree;
    static int[][] parents;
    static boolean[] visited;
    static int[] depth;

    private static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        for (int i = LOG - 1; i >= 0; i--)
            if (depth[b] - depth[a] >= (1 << i))
                b = parents[b][i];

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }

    private static void setParents() {
        dfs(1, 0);

        for (int i = 1; i < LOG; i++)
            for (int j = 1; j <= N; j++)
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
    }

    private static void dfs(int node, int dth) {
        visited[node] = true;
        depth[node] = dth;

        for (int next : tree[node]) {
            if (!visited[next]) {
                parents[next][0] = node;
                dfs(next, dth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        depth = new int[N + 1];
        parents = new int[N + 1][LOG];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        setParents();
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] arg = br.readLine().split("\\s");
            sb.append(lca(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
