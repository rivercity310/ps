package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15565 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    static void solve() {
        int len = Integer.MAX_VALUE;
        int right = 0;
        int cnt = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && cnt < M) if (arr[right++] == 1) cnt++;
            if (cnt == M) len = Math.min(len, right - left);
            if (arr[left] == 1) cnt--;
        }

        System.out.println(len == Integer.MAX_VALUE ? -1 : len);
    }
}
