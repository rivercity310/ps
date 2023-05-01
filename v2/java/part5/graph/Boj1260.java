package part5.graph;

import java.io.*;
import java.util.*;

public class Boj1260 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M, V;
    static List<ArrayList<Integer>> grp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        grp = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            grp.get(i).sort(Comparator.comparingInt(o -> o));
        }

        dfs(V);
        Arrays.fill(visited, false);
        sb.append('\n');
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(' ');

        for (int next : grp.get(start)) {
            if (!visited[next])
                dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');

            for (int next : grp.get(now)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
