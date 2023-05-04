package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7662 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int T, N;
    static TreeMap<Integer, Integer> m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            m = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    m.put(num, m.getOrDefault(num, 0) + 1);
                    continue;
                }

                if (m.size() == 0) continue;

                int key = num == -1 ? m.firstKey() : m.lastKey();
                int cnt = m.get(key);

                if (cnt == 1) m.remove(key);
                else m.put(key, cnt - 1);
            }

            if (m.size() == 0) sb.append("EMPTY");
            else sb.append(m.lastKey()).append(' ').append(m.firstKey());
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
