package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static boolean[] disabled;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        disabled = new boolean[10];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                disabled[k] = true;
            }
        }

        if (N == 100) System.out.println(0);
        else {
            ans = Math.abs(N - 100);

            for (int i = 0; i < 1000000; i++) {
                int cnt = move(i);

                if (cnt > 0) {
                    cnt += Math.abs(N - i);
                    ans = Math.min(ans, cnt);
                }
            }
            System.out.println(ans);
        }
    }

    static int move(int num) {
        if (num == 0) {
            if (!disabled[num]) return 1;
            return -1;
        }

        int len = 0;
        while (num > 0) {
            if (disabled[num % 10]) return -1;
            len++;
            num /= 10;
        }

        return len;
    }
}
