package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S;
    static int[] arr, prefix_sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        prefix_sum = new int[N + 1];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1];
        }

        System.out.println(solve());
    }

    static int solve() {
        int left = 0;
        int right = left + 1;
        int len = Integer.MAX_VALUE;

        while (right <= N && left <= right) {
            if (left == right) {
                if (prefix_sum[left] >= S) return 1;
                else right++;
            } else {
                int s = prefix_sum[right] - prefix_sum[left];
                if (s < S) right++;
                else {
                    len = Math.min(len, right - left);
                    left++;
                }
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
