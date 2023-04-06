package part5.back_tracking;

import java.util.Scanner;

public class Boj10974 {
    static final StringBuffer sb = new StringBuffer();
    static int[] arr;
    static boolean[] selected;
    static int N;

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        arr = new int[N];
        selected = new boolean[N];

        solve(0);
        System.out.print(sb);
    }

    static void solve(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                arr[depth] = i + 1;
                solve(depth + 1);
                selected[i] = false;
            }
        }
    }
}
