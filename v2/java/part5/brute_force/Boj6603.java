package part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj6603 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static final Deque<Integer> dq = new ArrayDeque<>();
    static StringTokenizer st;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            arr = new int[K];
            int idx = 0;

            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // 중복을 허용하지 않고 순서가 존재 (오름차순)
    static void solve(int start, int depth) {
        if (depth == 6) {
            dq.forEach(i -> sb.append(arr[i]).append(' '));
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            if (!dq.contains(i)) {
                dq.add(i);
                solve(i + 1, depth + 1);
                dq.removeLast();
            }
        }
    }
}
