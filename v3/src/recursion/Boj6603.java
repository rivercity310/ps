package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj6603 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;
    static int K;
    static int[] arr;
    static boolean[] chk;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            arr = new int[K];
            dq = new ArrayDeque<>();
            chk = new boolean[K];

            for (int i = 0; i < K; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            solve(0, 0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void solve(int start, int depth) {
        if (depth == 6) {
            dq.forEach(a -> sb.append(a).append(' '));
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            if (!chk[i]) {
                dq.addLast(arr[i]);
                chk[i] = true;
                solve(i + 1, depth + 1);
                chk[i] = false;
                dq.removeLast();
            }
        }
    }
}
