package part5.graph;

import java.util.*;
import java.io.*;

public class Boj2644 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ax, ay, x, y;
    static ArrayList<ArrayList<Integer>> grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grp = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        ax = Integer.parseInt(st.nextToken());
        ay = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            grp.get(x).add(y);
            grp.get(y).add(x);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        // ax -> ay 최단 이동 개수 구하기
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(ax);
        q.add(0);
        visited[ax] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            int chon = q.poll();

            for (int next : grp.get(now)) {
                if (next == ay) return chon + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    q.add(chon + 1);
                }
            }
        }

        return -1;
    }
}
