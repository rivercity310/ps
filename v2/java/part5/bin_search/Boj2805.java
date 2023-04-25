package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2805 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, max;
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
            max = Math.max(max, arr[i]);
        }

        System.out.println(solve());
    }

    static int solve() {
        int bottom = 1;
        int top = max;
        int ans = 0;

        while (bottom <= top) {
            int height = (bottom + top) / 2;
            long get = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > height) get += arr[i] - height;
            }

            if (M > get) top = height - 1;
            else {
                ans = Math.max(ans, height);
                bottom = height + 1;
            }
        }

        return ans;
    }
}
