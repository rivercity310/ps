package boj.Beginner.D_GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24480 {
    static final StringBuilder sb = new StringBuilder();
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static List<Integer>[] grp;
    static boolean[] visited;
    static int[] ans;
    static int cnt = 0;

    private static void solve(int start) {
        visited[start] = true;
        ans[start] = ++cnt;

        for (int k : grp[start])
            if (!visited[k])
                solve(k);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        ans = new int[n + 1];
        grp = new ArrayList[n + 1];
        Arrays.setAll(grp, elem -> new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            grp[u].add(v);
            grp[v].add(u);
        }

        for (List<Integer> arr : grp)
            Collections.sort(arr, Collections.reverseOrder());

        solve(r);

        for (int i = 1; i < ans.length; i++)
            sb.append(ans[i]).append('\n');

        System.out.print(sb);
    }
}