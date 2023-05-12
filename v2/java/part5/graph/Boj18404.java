package part5.graph;

import java.util.*;
import java.io.*;

public class Boj18404 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        int knightX = Integer.parseInt(st.nextToken());
        int knightY = Integer.parseInt(st.nextToken());
        map[knightX][knightY] = 0;

        bfs(knightX, knightY);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            sb.append(map[hx][hy]).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(int knightX, int knightY) {
        Queue<Integer> q = new LinkedList<>();
        int[][] dm = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} };

        q.add(knightX);
        q.add(knightY);

        while (!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();

            for (int[] tm : dm) {
                int nx = tm[0] + nowX;
                int ny = tm[1] + nowY;

                if (nx == knightX && ny == knightY) continue;
                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                if (map[nx][ny] != 0) continue;

                q.add(nx);
                q.add(ny);
                map[nx][ny] = map[nowX][nowY] + 1;
            }
        }
    }
}
