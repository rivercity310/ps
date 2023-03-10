package brute_force.basic;

// N과 M (2)
// 조합 (중복 허용 x, 오름차순)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m;
    static int[] selected;

    private static void rec(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++)
                sb.append(selected[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = selected[k - 1] + 1; i <= n; i++) {
            selected[k] = i;
            rec(k + 1);
            selected[k] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m + 1];

        rec(1);
        System.out.print(sb);
    }
}
