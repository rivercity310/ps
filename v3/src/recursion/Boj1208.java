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
    static long ans;
    static int[] arr;
    static Map<Integer, Long> map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        map = new HashMap<>();

        solve(N / 2, 0, 0);
        status = 1;
        solve(N, N / 2, 0);

        if (S == 0) ans--;
        System.out.println(ans);
    }

    private static void solve(int end, int index, int sum) {
        if (index == end) {
            if (status == 0) map.put(sum, map.getOrDefault(sum, 0L) + 1);
            else if (status == 1) ans += map.getOrDefault(S - sum, 0L);
            return;
        }

        solve(end, index + 1, sum + arr[index]);
        solve(end, index + 1, sum);
    }
}
