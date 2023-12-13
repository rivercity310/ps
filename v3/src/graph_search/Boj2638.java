package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2638 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, cheeseCnt, time;
    static int[] dx, dy;
    static int[][] arr, outAir;
    static boolean[][] visited;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    cheeseCnt++;
                    arr[i][j] = k;
                }
            }
        }

        solve();
        System.out.println(time);
    }

    private static void solve() {
        dx = new int[] { -1, 1, 0, 0 };
        dy = new int[] { 0, 0, -1, 1 };

        Deque<int[]> dq = new ArrayDeque<>();

        // 외부 공기 2, 치즈 1, 내부 공기 0
        while (cheeseCnt > 0) {
            outAir = new int[N][M];
            visited = new boolean[N][M];
            dfs(0, 0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {
                        if (outAir[i][j] >= 2) {
                            dq.add(new int[] { i, j });
                        }
                    }
                }
            }

            while (!dq.isEmpty()) {
                int[] ch = dq.removeFirst();
                arr[ch[0]][ch[1]] = 2;
                cheeseCnt--;
            }

            time++;
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        arr[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;

            if (visited[nx][ny])
                continue;

            if (arr[nx][ny] == 1) {
                outAir[nx][ny]++;
                continue;
            }

            dfs(nx, ny);
        }
    }
}
