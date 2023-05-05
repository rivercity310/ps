package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13305 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long[] dist, price;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new long[N];
        price = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        solve();
    }

    static void solve() {
        long ans = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            min = Long.min(price[i], min);
            ans += min * dist[i];
        }

        System.out.println(ans);
    }
}
