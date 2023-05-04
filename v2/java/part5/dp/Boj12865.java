package part5.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj12865 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static List<Integer> weights, values;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new ArrayList<>();
        values = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights.add(Integer.parseInt(st.nextToken()));
            values.add(Integer.parseInt(st.nextToken()));
        }

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            int cw = weights.get(i - 1);
            int cv = values.get(i - 1);

            for (int tw = 1; tw <= K; tw++) {
                if (tw < cw) dp[i][tw] = dp[i - 1][tw];
                else dp[i][tw] = Math.max(dp[i - 1][tw], dp[i - 1][tw - cw] + cv);
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println(dp[N][K]);
    }
}
