package part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1182 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        solve(0, 0);

        if (S == 0) ans -= 1;
        System.out.println(ans);
    }

    static void solve(int k, int sum) {
        if (k == N) {
            if (sum == S) ans++;
            return;
        }

        solve(k + 1, sum + arr[k]);
        solve(k + 1, sum);
    }
}
