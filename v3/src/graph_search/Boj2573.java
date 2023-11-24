package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2573 {
    static class Ice {
        int x, y, height;

        Ice(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static List<Ice> ices;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        ices = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[i][j] = k;
                if (k > 0) ices.add(new Ice(i, j, k));
                visited[i][j] = true;
            }
        }

        solve();
    }

    private static void solve() {
        for (int year = 1; !ices.isEmpty(); year++) {
            // 모든 빙산에 대해 접한 바다 개수를 조사
            for (Ice ice : ices) {
                search(ice);
            }

            for (int i = 0; i < ices.size(); i++) {
                Ice ice = ices.get(i);
                if (ice.height <= 0) {
                    arr[ice.x][ice.y] = 0;
                    ices.set(i, ices.get(ices.size() - 1));
                    ices.remove(ices.size() - 1);
                    i--;
                }
                else {
                    visited[ice.x][ice.y] = false;
                }
            }

            if (!ices.isEmpty() && dfs(ices.get(0).x, ices.get(0).y) != ices.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    private static int dfs(int x, int y) {
        int cnt = 1;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (!visited[nx][ny]) {
                cnt += dfs(nx, ny);
            }
        }

        return cnt;
    }

    // 특정 빙산 주변에 접한 바다의 개수를 카운트하는 함수
    private static void search(Ice ice) {
        for (int i = 0; i < 4; i++) {
            int nx = ice.x + dx[i];
            int ny = ice.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;

            if (arr[nx][ny] == 0)
                ice.height--;
        }
    }
}
