package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static char[] chars;
    static boolean[] selected;
    static int L, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        selected = new boolean[C];
        chars = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++)
            chars[i] = st.nextToken().charAt(0);

        Arrays.sort(chars);

        solve(0, 0);
        System.out.print(sb);
    }

    static void solve(int k, int start) {
        if (k == L) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < C; i++)
                if (selected[i])
                    tmp.append(chars[i]);

            if (isValidPassword(tmp.toString())) {
                sb.append(tmp).append('\n');
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (!selected[i]) {
                selected[i] = true;
                solve(k + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    static boolean isValidPassword(String tmp) {
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') cnt2++;
            else cnt1++;
        }

        return cnt1 >= 2 && cnt2 >= 1;
    }
}
