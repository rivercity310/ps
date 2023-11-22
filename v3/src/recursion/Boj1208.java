package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1208 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S, status;
    static int LEFT = 0, RIGHT = 1;
    static int[] arr;
    static long ans;
    static Map<Long, Long> cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        cnt = new HashMap<>();

        status = LEFT;
        solve(0, N / 2, 0);

        status = RIGHT;
        solve(N / 2, N, 0);

        if (S == 0) ans--;
        System.out.println(ans);
    }

    private static void solve(int index, int end, long sum) {
        if (index == end) {
            if (status == LEFT) {
                long prev = cnt.getOrDefault(sum, 0L);
                cnt.put(sum, prev + 1);
            }
            else if (status == RIGHT) ans += cnt.getOrDefault(S - sum, 0L);
            return;
        }

        solve(index + 1, end, sum);
        solve(index + 1, end, sum + arr[index]);
    }

}
