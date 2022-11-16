package Beginner.B_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class BigNumber {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);

        /*
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        */

        int idx = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        // 가장 큰 수가 더해지는 횟수
        int count = k * (m / (k + 1)) + m % (k + 1);         // m = 8, k = 3 -> aaabaaab

        int rst = (count * arr[n - 1]) + ((m - count) * arr[n - 2]);
        System.out.println(rst);

        br.close();
    }
}
