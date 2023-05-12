package part5.graph;

import java.util.*;
import java.io.*;

public class Boj3055 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, gx, gy, bx, by;
    static int[][] wmap, hmap;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Integer> q;
    static final int[][] dm = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wmap = new int[N][M];
        hmap = new int[N][M];
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(wmap[i], -1);
            Arrays.fill(hmap[i], -1);
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                char k = tmp.charAt(j);
                map[i][j] = k;
                if (k == 'S') {
                    gx = i;
                    gy = j;
                }
                else if (k == 'D') {
                    bx = i;
                    by = j;
                }
                else if (k == '*') {
                    q.add(i);
                    q.add(j);
                    visited[i][j] = true;
                    wmap[i][j] = 0;
                }
            }
        }

        bfs();
        System.out.println(hmap[bx][by] == -1 ? "KAKTUS" : hmap[bx][by]);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int[] d : dm) {
                int dx = x + d[0];
                int dy = y + d[1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
                if (map[dx][dy] != '.') continue;
                if (visited[dx][dy]) continue;
                wmap[dx][dy] = wmap[x][y] + 1;
                q.add(dx);
                q.add(dy);
                visited[dx][dy] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        q.add(gx);
        q.add(gy);
        hmap[gx][gy] = 0;
        visited[gx][gy] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int[] d : dm) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] != '.' && map[nx][ny] != 'D') continue;
                if (wmap[nx][ny] != -1 && wmap[nx][ny] <= hmap[x][y] + 1) continue;
                if (visited[nx][ny]) continue;

                hmap[nx][ny] = hmap[x][y] + 1;
                q.add(nx);
                q.add(ny);
                visited[nx][ny] = true;
            }
        }
    }
}