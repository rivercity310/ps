package boj.Beginner.k_backtracking;

import java.util.Scanner;

import static java.lang.Math.abs;

public class boj_9663 {
    private static int[] vx;

    private static int solve(int x, int y, int n) {
        for (int i = 0; i < y; i++) {
            if (x == vx[i]) return 0;     // 열 겹침 검사
            if (abs(x - vx[i]) == y - i) return 0; // 대각선 검사 (dy[i]와 i는 같음)
        }

        vx[y] = x;

        if (y == n - 1) {
            return 1;
        }

        int r = 0;
        for (int i = 0; i < n; i++) r += solve(i, y + 1, n);
        return r;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        vx = new int[n];

        int ans = 0;
        for (int i = 0; i < n; i++) ans += solve(i, 0, n);

        System.out.println(ans);
        scan.close();
    }
}
