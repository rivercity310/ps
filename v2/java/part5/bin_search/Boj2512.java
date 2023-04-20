package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(solve());
    }

    static int solve() {
        int left = 0;
        int right = arr[N - 1];
        int sum = Arrays.stream(arr).sum();
        int ans = left;

        if (M >= sum) return right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = 0;
            for (int k : arr) tmp += Math.min(k, mid);

            if (tmp <= M) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
}
