package Beginner.k_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14888 {
    private static StringTokenizer st;
    private static int N;
    private static int max_val = (int) -(1e9 + 1);
    private static int min_val = (int) (1e9 + 1);
    private static final List<Integer> nums = new ArrayList<>();
    private static final List<Integer> ops = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void solve(int depth, int result) {
        if (depth == N) {
            max_val = Math.max(max_val, result);
            min_val = Math.min(min_val, result);
            return;
        }

        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) > 0) {
                ops.set(i, ops.get(i) - 1);

                if (i == 0) solve(depth + 1, result + nums.get(depth));
                else if (i == 1) solve(depth + 1, result - nums.get(depth));
                else if (i == 2) solve(depth + 1, result * nums.get(depth));
                else if (i == 3) solve(depth + 1, result / nums.get(depth));

                ops.set(i, ops.get(i) + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) nums.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) ops.add(Integer.parseInt(st.nextToken()));

        solve(1, nums.get(0));
        System.out.println(max_val);
        System.out.println(min_val);
    }
}
