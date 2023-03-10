package brute_force.basic;

// N과 M (4)
// 중복 조합 (비내림차순)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15652 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static int n, m;
    static int[] selected;

    private static void rec(int k, int start) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++)
                sb.append(selected[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[k] = i;
            rec(k + 1, i);
            selected[k] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\s");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        selected = new int[m + 1];

        rec(1, 1);
        System.out.print(sb);
    }
}
