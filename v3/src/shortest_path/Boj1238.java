package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1238 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, X, ans, INF;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        INF = (int)1e9;

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            dist[u][v] = t;
        }

        for (int k = 1; k <= N; k++)
            for (int a = 1; a <= N; a++)
                for (int b = 1; b <= N; b++)
                    dist[a][b] = Math.min(dist[a][k] + dist[k][b], dist[a][b]);

        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i][X] + dist[X][i]);
        }

        System.out.println(ans);
    }
}
