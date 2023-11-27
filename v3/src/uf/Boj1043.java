package uf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1043 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static boolean[] truth;
    static int[] parent;
    static List<Integer>[] party;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        party = new List[M];
        parent = new int[N + 1];
        truth = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            truth[Integer.parseInt(st.nextToken())] = true;
        }


        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int pre = Integer.parseInt(st.nextToken());
            party[i].add(pre);

            for (int j = 1; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                party[i].add(k);
                unionParent(pre, k);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (truth[i]) {
                truth[findParent(i)] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            int pre = party[i].get(0);
            int pa = findParent(pre);
            if (!truth[pa]) ans++;
        }

        System.out.println(ans);
    }

    private static int findParent(int x) {
        if (parent[x] != x) return parent[x] = findParent(parent[x]);
        return x;
    }

    private static void unionParent(int a, int b) {
        int ra = findParent(a);
        int rb = findParent(b);

        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;
    }
}
