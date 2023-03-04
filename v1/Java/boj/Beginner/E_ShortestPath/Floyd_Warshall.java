package boj.Beginner.E_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd_Warshall {
    static final int MAX = 1000001;
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grp;

    private static void solve() {
        int size = grp.length;

        for (int k = 1; k < size; k++)
            for (int a = 1; a < size; a++)
                for (int b = 1; b < size; b++)
                    grp[a][b] = Math.min(grp[a][b], grp[a][k] + grp[k][b]);

        for (int a = 1; a < size; a++) {
            for (int b = 1; b < size; b++) {
                if (grp[a][b] == MAX) System.out.print("-1 ");
                else System.out.print(grp[a][b] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.setAll(grp[i], elem -> MAX);

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                if (i == j) grp[i][j] = 0;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            grp[x][y] = w;
        }

        solve();
    }
}
