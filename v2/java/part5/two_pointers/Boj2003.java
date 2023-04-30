package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2003 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solve());
    }

    static int solve() {
        int ans = 0;

        for (int left = 0; left < N; left++) {
            int sum = arr[left];
            if (sum == M) ans++;
            else {
                int right = left + 1;
                while (right < N && sum < M) {
                    sum += arr[right++];
                }

                if (sum == M) ans++;
            }
        }

        return ans;
    }
}
