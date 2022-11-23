package Beginner.D_GraphSearch;

import java.io.*;
import java.util.*;

public class boj_24445 {
    static List<Integer>[] grp;
    static StringTokenizer st;
    static final StringBuilder sb = new StringBuilder();
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static void solve(int r) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[grp.length];

        q.add(r);
        visited[r] = true;

        int[] ans = new int[grp.length];
        int cnt = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            ans[now] = cnt++;

            for (int nxt : grp[now]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        for (int i = 1; i < ans.length; i++)
            sb.append(ans[i]).append("\n");

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        grp = new ArrayList[n + 1];
        Arrays.setAll(grp, elem -> new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            grp[u].add(v);
            grp[v].add(u);
        }

        for (var g : grp)
            Collections.sort(g, Collections.reverseOrder());

        solve(r);

        br.close();
    }
}
