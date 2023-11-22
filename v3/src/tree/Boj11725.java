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
    static List<Integer>[] grp;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        parent[1] = -1;
        grp = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            grp[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            grp[u].add(v);
            grp[v].add(u);
        }

        solve(1, -1);
        for (int i = 2; i <= N; i++)
            System.out.println(parent[i]);
    }

    private static void solve(int node, int par) {
        for (int next : grp[node]) {
            if (next != par) {
                parent[next] = node;
                solve(next, node);
            }
        }
    }
}
