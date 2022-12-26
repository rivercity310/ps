package boj.Beginner.k_backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj_15652 {
    private static final StringBuilder sb = new StringBuilder();
    private static final Deque<Integer> deq = new ArrayDeque<>();


    private static void solve(int depth, int start, int n, int m) {
        if (depth == m) {
            deq.forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            deq.add(i);
            solve(depth + 1, i, n, m);
            deq.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arg = scan.nextLine().split(" ");

        int n = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);

        solve(0, 1, n, m);
        System.out.print(sb);
        scan.close();
    }
}
