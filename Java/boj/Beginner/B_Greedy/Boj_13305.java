package boj.Beginner.B_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13305 {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = Integer.parseInt(st.nextToken());

        /* 자바에는 부호없는 정수 자료형 따로 없다 */
        long total = 0;
        int min_price = Integer.MAX_VALUE;

        /* Long.valueOf() : int to long casting */
        for (int i = 0; i < n - 1; i++) {
            min_price = Integer.min(min_price, prices[i]);
            total += Long.valueOf(min_price) * Long.valueOf(dist[i]);
        }

        System.out.println(total);
    }

}
