package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                grp[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(grp[N - 1][M - 1]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (grp[nx][ny] == 1) {
                    grp[nx][ny] = grp[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
