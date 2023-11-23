package dq;

import java.util.Scanner;

public class Boj1074 {
    static int N, R, C, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();

        solve(N, R, C);
        System.out.println(cnt);
    }

    private static void solve(int n, int i, int j) {
        int size = 1 << n;
        int mid = size >> 1;

        if (n == 0) return;

        // divide
        if (i < mid && j < mid) {
            solve(n - 1, i, j);
        }
        else if (i < mid && j >= mid) {
            cnt += mid * mid;
            solve(n - 1, i, j - mid);
        }
        else if (i >= mid && j < mid) {
            cnt += (mid * mid) * 2;
            solve(n - 1, i - mid, j);
        }
        else {
            cnt += (mid * mid) * 3;
            solve(n - 1, i - mid, j - mid);
        }
    }
}
