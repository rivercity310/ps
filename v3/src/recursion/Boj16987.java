package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16987 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, max;
    static int[] S, W;
    static boolean[] breaks;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        breaks = new boolean[N];
        S = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            S[i] = x;
            W[i] = y;
        }

        solve(0);
        System.out.println(max);
    }

    private static void solve(int now) {
        // Base case
        // 1. 현재 제일 오른쪽 계란을 집은 경우
        // 2. 모든 계란이 깨진 경우
        if (now == N) {
            int cnt = 0;

            for (int i = 0; i < N; i++)
                if (breaks[i]) cnt++;

            max = Math.max(max, cnt);
            return;
        }

        // Recursive Case

        // 1. 손에 잡은 계란이 깨진 경우 다음 계란을 집는다.
        if (breaks[now]) {
            solve(now + 1);
        }

        // 2. 깨지지 않았다면 다른 계란과 충돌시킨다.
        else {
            boolean targetExists = false;

            for (int i = 0; i < N; i++) {
                if (breaks[i] || now == i) continue;
                targetExists = true;

                S[i] -= W[now];
                S[now] -= W[i];
                if (S[i] <= 0) breaks[i] = true;
                if (S[now] <= 0) breaks[now] = true;

                solve(now + 1);

                S[i] += W[now];
                S[now] += W[i];
                if (breaks[i]) breaks[i] = false;
                if (breaks[now]) breaks[now] = false;
            }

            // 2 - 1. 모든 계란이 깨져서 타겟이 없는 경우 다음 계란을 집는다.
            if (!targetExists) solve(now + 1);
        }
    }
}
