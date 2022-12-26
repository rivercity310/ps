package boj.Intermediate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11437 {
    static int N, M;
    static List<Integer>[] tree;
    static int[] depth;
    static int[] parents;
    static boolean[] visited;
    
    private static int lca(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) a = parents[a];
            else b = parents[b];
        }

        while (a != b) {
            a = parents[a];
            b = parents[b];
        }

        return a;
    }

    private static void dfs(int node, int dth) {
        visited[node] = true;
        depth[node] = dth;

        for (int next : tree[node]) {
            if (!visited[next]) {
                parents[next] = node;
                dfs(next, dth + 1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        depth = new int[N + 1];
        parents = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            String[] arg = br.readLine().split("\\s");
            int a = Integer.parseInt(arg[0]);
            int b = Integer.parseInt(arg[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] arg = br.readLine().split("\\s");
            sb.append(lca(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
