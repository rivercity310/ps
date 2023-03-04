package boj.Beginner.k_backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj_15650 {
    private static final Deque<Integer> arr = new ArrayDeque<>();
    private static final StringBuilder sb = new StringBuilder();

    private static void solve(int depth, int start, int n, int m) {
        if (depth == m) {
            arr.forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!arr.contains(i)) {
                arr.add(i);
                solve(depth + 1, i + 1, n, m);
                arr.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arg = sc.nextLine().split(" ");
        int n = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);

        solve(0, 1, n, m);
        System.out.print(sb);
    }
}
