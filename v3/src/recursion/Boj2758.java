package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2758 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new long[N + 1][M + 1];
            for (int i = 1; i <= N; i++) Arrays.fill(dp[i], -1);
            System.out.println(solve(M, N));
        }
    }

    private static long solve(int last, int index) {
        if (last <= 0) return 0;
        if (index == 1) return last;
        if (dp[index][last] == -1)
            dp[index][last] = solve(last / 2, index - 1) + solve(last - 1, index);
        return dp[index][last];
    }
}
