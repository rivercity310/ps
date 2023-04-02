package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14889 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] T;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        T = new boolean[N];

        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        }

        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int depth, int start) {
        if (depth == N / 2) {
            int startScore = 0;
            int linkScore = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (T[i] && T[j]) startScore += S[i][j];
                    if (!T[i] && !T[j]) linkScore += S[i][j];
                }
            }

            ans = Math.min(ans, Math.abs(startScore - linkScore));
            return;
        }

        for (int i = start; i < N; i++) {
            if (!T[i]) {
                T[i] = true;
                solve(depth + 1, i);
                T[i] = false;
            }
        }
    }
}