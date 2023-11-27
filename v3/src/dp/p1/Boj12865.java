package dp.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865 {
    static int N, K;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);
    }
}
