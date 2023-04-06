package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2580 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static final List<int[]> zeros = new ArrayList<>();
    static final int N = 9;
    static StringTokenizer st;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int token = Integer.parseInt(st.nextToken());
                if (token == 0) zeros.add(new int[] { i, j });
                map[i][j] = token;
            }
        }

        solve(0);
    }

    static void solve(int cur) {
        if (cur == zeros.size()) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    sb.append(map[i][j]).append(' ');
                sb.append('\n');
            }

            System.out.print(sb);
            System.exit(0);
        }

        int row = zeros.get(cur)[0];
        int col = zeros.get(cur)[1];

        for (int i = 1; i <= N; i++) {
            if (chk(row, col, i)) {
                map[row][col] = i;
                solve(cur + 1);
                map[row][col] = 0;
            }
        }
    }

    static boolean chk(int row, int col, int i) {
        for (int k = 0; k < N; k++)
            if (map[row][k] == i || map[k][col] == i)
                return false;

        int vx = (row / 3) * 3;
        int vy = (col / 3) * 3;

        for (int a = vx; a < vx + 3; a++)
            for (int b = vy; b < vy + 3; b++)
                if (map[a][b] == i)
                    return false;

        return true;
    }
}