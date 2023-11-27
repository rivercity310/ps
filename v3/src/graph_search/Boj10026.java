package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026 {
    static BufferedReader br;
    static int N, R, G, B;
    static int[] dx, dy;
    static int[][] grp;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = 0; G = 1; B = 2;
        dx = new int[] { -1, 1, 0, 0 };
        dy = new int[] { 0, 0, -1, 1 };
        q = new LinkedList<>();
        grp = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == 'R') grp[i][j] = R;
                else if (ch[j] == 'G') grp[i][j] = G;
                else grp[i][j] = B;
            }
        }

        ans = new int[2];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    ans[0]++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grp[i][j] == G) grp[i][j] = R;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    ans[1]++;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    private static void bfs(int i, int j) {
        int district = grp[i][j];

        q.add(new int[] { i, j });
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int a = 0; a < 4; a++) {
                int nx = x + dx[a];
                int ny = y + dy[a];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if (grp[nx][ny] == district) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
