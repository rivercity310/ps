package dq;

import java.util.Scanner;

public class Boj1629 {
    static int A, B, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.println(solve(A, B, C));
    }

    private static long solve(int a, int b, int c) {
        // conquer
        if (b == 1) return a % c;

        // divide
        long half = solve(a, b / 2, c);

        // combine
        if (b % 2 == 0) return half * half % c;
        return (((half * half) % c) * (a % c)) % c;
    }
}
