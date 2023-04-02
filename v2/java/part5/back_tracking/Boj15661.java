package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15661 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static int[][] S;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solve(0);
        System.out.println(ans);
    }

    static void solve(int depth) {
        if (depth == N) {
            ans = Math.min(ans, calc());
            return;
        }

        checked[depth] = true;
        solve(depth + 1);
        checked[depth] = false;
        solve(depth + 1);
    }

    static int calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (checked[i] == checked[j]) {
                    if (checked[i]) start += S[i][j] + S[j][i];
                    else link += S[i][j] + S[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }
}
