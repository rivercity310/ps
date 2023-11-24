package dp.p1;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2294 {
    static int N, K;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        coin = new int[N];
        dp = new int[K + 1];
        Arrays.fill(dp, 100001);

        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
            if (coin[i] <= K) {
                dp[coin[i]] = 1;
            }
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                if (i + coin[j] <= K) {
                    dp[i + coin[j]] = Math.min(dp[i] + 1, dp[i + coin[j]]);
                }
            }
        }

        System.out.println(dp[K] == 100001 ? -1 : dp[K]);
    }
}
