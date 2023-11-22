package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10971 {
    static int N, ans;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            solve(i, i, 0, 0);
        }
        System.out.println(ans);
    }

    private static void solve(int start, int now, int depth, int sum) {
        if (depth == N) {
            if (start == now) ans = Math.min(sum, ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                solve(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}
