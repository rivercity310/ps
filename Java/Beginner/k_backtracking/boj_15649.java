package Beginner.k_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj_15649 {
    private static final List<Integer> lst = new ArrayList<>();
    private static Boolean[] visited;

    private static void solve(int depth, int n, int m) {
        if (depth == m) {
            lst.forEach(i -> System.out.print(i + 1 + " "));
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            lst.add(i);
            solve(depth + 1, n, m);
            visited[i] = false;
            lst.remove(lst.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("\s");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        visited = new Boolean[n];
        Arrays.fill(visited, false);
        solve(0, n, m);
    }
}
