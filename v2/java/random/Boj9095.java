package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {
    static BufferedReader br;
    static StringBuffer sb;
    static int T, N, ans;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            if (N == 1) ans = 1;
            else if (N == 2) ans = 2;
            else if (N == 3) ans = 4;
            else {
                dp = new int[N + 1];
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int i = 4; i <= N; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }

                ans = dp[N];
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
