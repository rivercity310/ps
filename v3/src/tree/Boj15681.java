package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 트리와 쿼리 */
public class Boj15681 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, R, Q;
    static List<Integer>[] grp;
    static int[] parent;
    static int[] size;

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void makeTree(int curr, int par) {
        for (int node : grp[curr]) {
            if (node != par) {
                parent[node] = curr;
                makeTree(node, curr);
            }
        }
    }

    private static void countSubtreeNodes(int curr) {
        size[curr] = 1;

        for (int node : grp[curr]) {
            if (parent[curr] != node) {
                countSubtreeNodes(node);
                size[curr] += size[node];
            }
        }
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        grp = new List[N + 1];
        size = new int[N + 1];
        parent = new int[N + 1];
        parent[R] = -1;

        for (int i = 0; i <= N; i++) {
            grp[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grp[a].add(b);
            grp[b].add(a);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
}
