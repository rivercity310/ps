package boj.Beginner.k_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2580 {

    static StringTokenizer st;
    static final int MAX = 9;
    static final int[][] arr = new int[MAX][MAX];
    static final List<int[]> v = new ArrayList<>();
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static boolean chk(int row, int col, int i) {
        for (int k = 0; k < MAX; k++)
            if (arr[row][k] == i || arr[k][col] == i) return false;

        int vx = (row / 3) * 3;
        int vy = (col / 3) * 3;

        for (int a = vx; a < vx + 3; a++)
            for (int b = vy; b < vy + 3; b++)
                if (arr[a][b] == i) return false;

        return true;
    }

    private static boolean dfs(int cur) {
        if (cur == v.size()) return true;

        int row = v.get(cur)[0];
        int col = v.get(cur)[1];

        for (int i = 1; i <= MAX; i++) {
            if (chk(row, col, i)) {
                arr[row][col] = i;
                if (dfs(cur + 1)) return true;
                arr[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < MAX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) v.add(new int[] { i, j });
            }
        }

        dfs(0);

        for (var a : arr) {
            for (var b : a) System.out.print(b + " ");
            System.out.println();
        }
    }
}
