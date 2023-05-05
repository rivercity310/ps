package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj5430 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int T, N;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] func = br.readLine().replaceAll("R{2}", "").toCharArray();
            N = Integer.parseInt(br.readLine());

            String tmp = br.readLine();
            tmp = tmp.substring(1, tmp.length() - 1);

            st = new StringTokenizer(tmp, ",");
            dq = new ArrayDeque<>();

            while (st.hasMoreTokens())
                dq.add(Integer.parseInt(st.nextToken()));

            boolean reverse = false;
            boolean error = false;

            for (char f : func) {
                if (f == 'R') reverse = !reverse;
                if (f == 'D') {
                    if (dq.isEmpty()) {
                        sb.append("error");
                        error = true;
                        break;
                    }
                    if (reverse) dq.removeLast();
                    else dq.removeFirst();
                }
            }

            if (!error) {
                sb.append('[');
                while (!dq.isEmpty()) {
                    if (reverse) sb.append(dq.removeLast());
                    else sb.append(dq.removeFirst());
                    if (dq.size() != 0) sb.append(',');
                }
                sb.append(']');
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
