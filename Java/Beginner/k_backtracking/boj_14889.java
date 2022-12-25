package Beginner.k_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14889 {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] S = new int[20][20];
    static Boolean[] C = new Boolean[20];
    static StringTokenizer st;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void dfs(int depth, int start) {
        if (start == N) return;

        if (depth == N / 2) {
            int startScore = 0;
            int linkScore = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (C[i] && C[j]) startScore += S[i][j];
                    if (!C[i] && !C[j]) linkScore += S[i][j];
                }
            }

            ans = Math.min(ans, Math.abs(startScore - linkScore));
            return;
        }

        C[start] = true;
        dfs(depth + 1, start + 1);
        C[start] = false;
        dfs(depth, start + 1);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Arrays.fill(C, false);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }
}
