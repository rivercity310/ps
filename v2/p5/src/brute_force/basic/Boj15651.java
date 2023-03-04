package brute_force.basic;

// N과 M (3)
// 1부터 N까지 자연수 중에서 M개를 중복을 허용하여 고른다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj15651 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static final Deque<Integer> dq = new ArrayDeque<>();
    static int n, m;

    private static void printAll() {
        for (int k : dq) {
            sb.append(k).append(' ');
        }

        sb.append('\n');
    }

    private static void rec(int len) {
        if (len == m) {
            printAll();
            return;
        }

        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
            rec(len + 1);
            dq.removeLast();
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("\\s");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        rec(0);
        System.out.println(sb);
    }
}
