package Beginner.B_Greedy;

import java.util.Scanner;

public class Exchange {
    private static final Scanner scan = new Scanner(System.in);
    private static final int[] coins = { 500, 100, 50, 10 };
    private static int[] coins_cnt = { 0, 0, 0, 0 };

    public static void main(String[] args) {
        int n = scan.nextInt();
        int idx = 0;

        for (int coin : coins) {
            coins_cnt[idx++] += n / coin;
            n %= coin;
        }

        System.out.println("[ 동전의 개수 ]");
        for (int cnt : coins_cnt)
            System.out.print(cnt + " ");

        scan.close();
    }
}
