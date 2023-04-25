package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2467 {
    static BufferedReader br;
    static int N, v1, v2, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        max = Integer.MAX_VALUE;
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < N - 1; i++) {
            solve(i);
        }

        System.out.println(arr[v1] + " " + arr[v2]);
    }

    static void solve(int now) {
        int left = now + 1;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = arr[now] + arr[mid];

            if (max >= Math.abs(sum)) {
                max = Math.abs(sum);
                v1 = now;
                v2 = mid;
            }

            if (sum <= 0) left = mid + 1;
            else right = mid - 1;
        }
    }
}
