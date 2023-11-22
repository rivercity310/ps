package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1182 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int depth, int sum) {
        if (depth == N) return;
        if (sum + arr[depth] == S) ans++;

        solve(depth + 1, sum);
        solve(depth + 1, sum + arr[depth]);
    }
}
