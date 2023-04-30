package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj13144 {
    static BufferedReader br;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve();
    }

    static void solve() {
        int max = Arrays.stream(arr).max().getAsInt();
        int right = 0;
        long cnt = 0;

        boolean[] visited = new boolean[max + 1];

        for (int left = 0; left < N; left++) {
            while (right < N && !visited[arr[right]]) {
                visited[arr[right++]] = true;
            }

            visited[arr[left]] = false;
            cnt += right - left;
        }

        System.out.println(cnt);
    }
}
