package brute_force.basic;

// N과 M (1)
// 1부터 N까지 자연수 중에서 중복을 허용하지 않고 M개를 고른 수열 모두 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15649 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[] selected;
    static boolean[] used;

    private static void rec(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int cand = 1; cand <= n; cand++) {
            if (used[cand]) continue;

            selected[k] = cand; used[cand] = true;
            rec(k + 1);
            selected[k] = 0; used[cand] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\s");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        selected = new int[m + 1];
        used = new boolean[n + 1];

        rec(1);

        System.out.print(sb);
    }
}
