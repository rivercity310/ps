package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj2239 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static final int N = 9;
    static int[][] sudoku;
    static List<int[]> zeros;

    public static void main(String[] args) throws IOException {
        sudoku = new int[N][N];
        zeros = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                int k = input.charAt(j) - '0';
                if (k == 0) zeros.add(new int[] { i, j });
                sudoku[i][j] = k;
            }
        }

        solve(0);
    }

    static void solve(int k) {
        if (k == zeros.size()) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    sb.append(sudoku[i][j]);
                sb.append('\n');
            }

            System.out.print(sb);
            System.exit(0);
        }

        int x = zeros.get(k)[0];
        int y = zeros.get(k)[1];

        for (int num = 1; num <= N; num++) {
            if (chk(num, x, y)) {
                sudoku[x][y] = num;
                solve(k + 1);
                sudoku[x][y] = 0;
            }
        }
    }

    static boolean chk(int num, int x, int y) {
        for (int k = 0; k < N; k++)
            if (sudoku[x][k] == num || sudoku[k][y] == num)
                return false;

        int dx = (x / 3) * 3;
        int dy = (y / 3) * 3;

        for (int i = dx; i < dx + 3; i++)
            for (int j = dy; j < dy + 3; j++)
                if (sudoku[i][j] == num)
                    return false;

        return true;
    }
}
