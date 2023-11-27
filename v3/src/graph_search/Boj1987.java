package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1987 {
    static BufferedReader br;
    static StringTokenizer st;
    static int R, C, ans;
    static int[] dx, dy;
    static int[][] board;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        dx = new int[] { -1, 1, 0, 0 };
        dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < R; i++) {
            char[] ch = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                board[i][j] = ch[j] - 'A';
            }
        }

        set = new HashSet<>();
        set.add(board[0][0]);

        solve(0, 0, 1);
        System.out.println(ans);
    }

    private static void solve(int x, int y, int cnt) {
        ans = Math.max(ans, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            if (!set.contains(board[nx][ny])) {
                set.add(board[nx][ny]);
                solve(nx, ny, cnt + 1);
                set.remove(board[nx][ny]);
            }
        }
    }
}
