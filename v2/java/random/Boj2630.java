package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = new int[2];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
            }
        }

        solve(0, 0, N);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    static void solve(int row, int col, int n) {
        if (chk(row, col, n)) {
            ans[map[row][col]]++;
            return;
        }

        n /= 2;

        solve(row, col, n);
        solve(row, col + n, n);
        solve(row + n, col, n);
        solve(row + n, col + n, n);
    }

    static boolean chk(int row, int col, int n) {
        int a = map[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (map[i][j] != a) return false;
            }
        }

        return true;
    }
}
