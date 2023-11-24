package dp.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2156 {
    static BufferedReader br;
    static int N;
    static int[] wines;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        wines = new int[N];
        dp = new int[3][N];

        for (int i = 0; i < N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = 0;
        dp[1][0] = wines[0];
        dp[2][0] = wines[0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
            dp[1][i] = dp[0][i - 1] + wines[i];
            dp[2][i] = dp[1][i - 1] + wines[i];
        }

        System.out.println(Math.max(dp[0][N - 1], Math.max(dp[1][N - 1], dp[2][N - 1])));
    }
}
