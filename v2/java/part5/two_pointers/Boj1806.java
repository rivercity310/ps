package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1806 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve();
    }

    static void solve() {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (true) {
            while (sum >= S) {
                ans = Math.min(ans, right - left);
                sum -= arr[left++];
            }

            if (right == N) break;
            sum += arr[right++];
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}