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
        arr = new int[N][N];
        visited = new boolean[N];
        ans = Integer.MAX_VALUE;

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

    private static void solve(int start, int node, int sum, int depth) {
        if (depth == N && start == node) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[node][i] > 0) {
                visited[i] = true;
                solve(start, i, sum + arr[node][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
