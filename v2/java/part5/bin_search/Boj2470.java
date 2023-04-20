package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, tmp, v1, v2;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tmp = Integer.MAX_VALUE;
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (tmp > Math.abs(sum)) {
                tmp = Math.abs(sum);
                v1 = start;
                v2 = end;
            }

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(arr[v1] + " " + arr[v2]);
    }
}
