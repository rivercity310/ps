package part5.brute_force;

import java.util.Scanner;

public class Boj9663 {
    static int N, cnt;
    static int[] queen;

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        queen = new int[N];
        solve(0);
        System.out.println(cnt);
    }

    static void solve(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (possible(row, col)) {
                queen[row] = col;
                solve(row + 1);
                queen[row] = 0;
            }
        }
    }

    static boolean possible(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (attackable(row, col, i, queen[i]))
                return false;
        }

        return true;
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }
}
