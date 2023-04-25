package part5.bin_search;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1654 {
    static BufferedReader br;
    static StringTokenizer st;
    static int K, N, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(solve());
    }

    static long solve() {
        long left = 1;
        long right = max;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (N > cnt) right = mid - 1;
            else {
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
        }

        return ans;
    }
}
