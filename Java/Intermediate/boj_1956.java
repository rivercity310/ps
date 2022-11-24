package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1956 {
    private static final int INF = (int) 1e9;
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static int[][] grp;


    private static int solve() {
        for (int k = 1; k < grp.length; k++)
            for (int i = 1; i < grp.length; i++)
                for (int j = 1; j < grp.length; j++)
                    grp[i][j] = Math.min(grp[i][j], grp[i][k] + grp[k][j]);

        int ans = INF;

        for (int i = 1; i < grp.length; i++) {
            for (int j = 1; j < grp.length; j++) {
                if (i == j) continue;
                ans = Math.min(ans, grp[i][j] + grp[j][i]);
            }
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        grp = new int[v + 1][v + 1];
        for (int i = 1; i < grp.length; i++)
            Arrays.fill(grp[i], INF);

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grp[a][b] = c;
        }

        System.out.println(solve());
    }
}
