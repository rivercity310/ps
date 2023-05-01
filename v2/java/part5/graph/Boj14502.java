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
    static int[] picked;
    static boolean[][] visited;
    static boolean[] pick_check;
    static List<int[]> viruses, zeros;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grp = new int[N][M];
        visited = new boolean[N][M];
        picked = new int[3];
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

        pick_check = new boolean[zeros.size()];
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int start, int depth) {
        if (depth == 3) {
            for (int idx : picked) {
                int[] p = zeros.get(idx);
                grp[p[0]][p[1]] = 1;
            }

            bfs();

            for (int idx : picked) {
                int[] p = zeros.get(idx);
                grp[p[0]][p[1]] = 0;
            }

            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    visited[i][j] = false;

            return;
        }

        for (int i = start; i < zeros.size(); i++) {
            if (!pick_check[i]) {
                pick_check[i] = true;
                picked[depth] = i;
                solve(i + 1, depth + 1);
                picked[depth] = 0;
                pick_check[i] = false;
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int[] virus : viruses) {
            q.add(virus[0]);
            q.add(virus[1]);
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (grp[nx][ny] != 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (grp[i][j] == 0 && !visited[i][j])
                    cnt++;

        ans = Math.max(ans, cnt);
    }
}
