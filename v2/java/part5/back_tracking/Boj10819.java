package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Boj10819 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final Deque<Integer> dq = new ArrayDeque<>();
    static int[] nums;
    static boolean[] checked;
    static int N;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N];
        nums = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve(0);
        System.out.print(ans);
    }

    static void solve(int depth) {
        if (depth == N) {
            ans = Math.max(ans, calc());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dq.add(nums[i]);
                solve(depth + 1);
                dq.removeLast();
                checked[i] = false;
            }
        }
    }

    static int calc() {
        int sum = 0;
        int[] tmp = dq.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(tmp[i] - tmp[i + 1]);
        }

        return sum;
    }
}
