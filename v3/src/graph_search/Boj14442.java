package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14442 {
    static class Status {
        int x, y, status;

        Status(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, K;
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                int k = ch[j] - '0';
                map[i][j] = k;
            }
        }

        solve();
    }

    private static void solve() {
        Queue<Status> q = new LinkedList<>();
        q.add(new Status(0, 0, 0));

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            Status now = q.poll();
            int x = now.x;
            int y = now.y;
            int status = now.status;

            if (x == N - 1 && y == M - 1) {
                System.out.println(visited[x][y][status]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny][status] != 0) continue;

                // 벽을 부수지 않는 경우
                if (map[nx][ny] == 0) {
                    visited[nx][ny][status] = visited[x][y][status] + 1;
                    q.add(new Status(nx, ny, status));
                }

                // 벽을 부수는 경우
                else if (map[nx][ny] == 1 && status < K && visited[nx][ny][status + 1] == 0) {
                    visited[nx][ny][status + 1] = visited[x][y][status] + 1;
                    q.add(new Status(nx, ny, status + 1));
                }
            }
        }

        System.out.println(-1);
    }
}
