package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10971 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static int[][] W;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        visited = new boolean[N];
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            W[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            solve(i, i, 0, 0);
        }

        System.out.println(ans);
    }

    static void solve(int start, int now, int depth, int sum) {
        if (depth == N && start == now) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (W[now][i] > 0 && !visited[i]) {
                visited[i] = true;
                sum += W[now][i];
                solve(start, i, depth + 1, sum);
                sum -= W[now][i];
                visited[i] = false;
            }
        }
    }
}
