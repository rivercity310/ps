package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2758 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;
    static int T, N, M;
    static long[][] mem;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuffer();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            mem = new long[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(mem[i], -1);
            }

            sb.append(solve(N, M)).append('\n');
        }

        System.out.print(sb);
    }

    private static long solve(int i, int last) {
        if (last <= 0) return 0;
        if (i == 1) return last;
        if (mem[i][last] == -1) {
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return mem[i][last];
    }
}
