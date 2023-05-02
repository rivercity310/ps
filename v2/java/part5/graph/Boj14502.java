package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14502 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static int[][] grp;
    static int[] pick;
    static boolean[] pck;
    static boolean[][] visited;
    static List<int[]> zeros;
    static List<int[]> viruses;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pick = new int[3];
        grp = new int[N][M];
        visited = new boolean[N][M];
        zeros = new ArrayList<>();
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 0) zeros.add(new int[] { i, j });
                if (k == 2) viruses.add(new int[] { i, j });
                grp[i][j] = k;
            }
        }

        pck = new boolean[zeros.size()];

        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int depth, int start) {
        if (depth == 3) {
            for (int p : pick) {
                int[] idx = zeros.get(p);
                grp[idx[0]][idx[1]] = 1;
            }

            int k = bfs();

            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    visited[i][j] = false;

            for (int p : pick) {
                int[] idx = zeros.get(p);
                grp[idx[0]][idx[1]] = 0;
            }

            ans = Math.max(ans, k);

            return;
        }

        for (int i = start; i < zeros.size(); i++) {
            if (!pck[i]) {
                pck[i] = true;
                pick[depth] = i;
                solve(depth + 1, i + 1);
                pck[i] = false;
            }
        }
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();

        for (int[] virus : viruses) {
            q.add(virus[0]);
            q.add(virus[1]);
            visited[virus[0]][virus[1]] = true;
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (grp[nx][ny] == 1) continue;

                q.add(nx);
                q.add(ny);
                visited[nx][ny] = true;
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (grp[i][j] == 0 && !visited[i][j]) cnt++;

        return cnt;
    }
}