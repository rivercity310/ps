package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, R, C;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(solve((int) Math.pow(2, N), R, C));
    }

    static long solve(int n, int r, int c) {
        if (n == 1)
            return 0;
        if (r < n / 2 && c < n / 2)
            return solve(n / 2, r, c);
        else if (r < n / 2 && c >= n / 2)
            return (long) n * n / 4 + solve(n / 2, r, c - (n / 2));
        else if (r >= n / 2 && c < n / 2)
            return (long) n * n / 2 + solve(n / 2, r - (n / 2), c);
        else
            return 3L * n * n / 4 + solve(n / 2, r - (n / 2), c - (n / 2));
    }
}
