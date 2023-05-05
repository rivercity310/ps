package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2206 {
    static class Point {
        int x, y, dist, use;

        public Point(int x, int y, int dist, int use) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.use = use;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static int[] dx, dy;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        dx = new int[] { -1, 1, 0, 0 };
        dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                int k = tmp.charAt(j) - '0';
                map[i][j] = k;
            }
        }

        bfs();
    }

    static void bfs() {
        visited[0][0][0] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                ans = Math.min(ans, p.dist);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (visited[nx][ny][p.use])
                    continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny][p.use] = true;
                    q.add(new Point(nx, ny,p.dist + 1, p.use));
                }

                else if (map[nx][ny] == 1 && p.use == 0) {
                    visited[nx][ny][1] = true;
                    q.add(new Point(nx, ny, p.dist + 1, 1));
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
