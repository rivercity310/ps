package boj.Beginner.B_Greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class UntilNumberOne {
    private static final Scanner scan = new Scanner(System.in);
    private static StringTokenizer st;

    public static void main(String[] args) {
        st = new StringTokenizer(scan.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (n != 1) {
            if (n % k == 0)
                n /= k;
            else
                n -= 1;

            cnt++;
        }

        System.out.println(cnt);
        scan.close();
    }
}
