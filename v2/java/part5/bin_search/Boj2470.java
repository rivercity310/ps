package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tmp = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 0; i < N - 1; i++) {
            int start = i + 1;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = arr[i] + arr[mid];

                if (Math.abs(sum) < tmp) {
                    tmp = Math.abs(sum);
                    v1 = i;
                    v2 = mid;
                }

                if (sum < 0) start = mid + 1;
                else end = mid - 1;
            }
        }

        System.out.println(arr[v1] + " " + arr[v2]);
    }
}
