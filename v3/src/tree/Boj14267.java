package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14267 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] grp;
    static int[] parent, size;

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        parent[1] = -1;
        size = new int[N + 1];
        grp = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            grp[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int sup = Integer.parseInt(st.nextToken());
            if (sup == -1) continue;
            grp[sup].add(i);
            grp[i].add(sup);
        }
    }

    private static void solve() throws IOException {
        findParentNode(1, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            size[e] += w;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 2; i <= N; i++) {
            if (size[i] > 0) {
                calcEmployeeSize(i);
            }
        }

        for (int i = 1; i <= N; i++)
            sb.append(size[i]).append(' ');
        System.out.println(sb);
    }

    private static void calcEmployeeSize(int curr) {
        for (int node : grp[curr]) {
            if (node != parent[curr]) {
                size[node] += size[curr];
            }
        }
    }

    private static void findParentNode(int cur, int par) {
        for (int node : grp[cur]) {
            if (node != par) {
                parent[node] = cur;
                findParentNode(node, cur);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
