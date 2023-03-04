package boj.Beginner.k_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_6603 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static List<Integer> ans;
    private static List<Integer> nums;
    private static StringTokenizer st;

    private static void solve(int depth, int start, int k) {
        if (depth == 6) {
            ans.forEach(i -> sb.append(i).append(' '));
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            ans.add(nums.get(i));
            solve(depth + 1, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            ans = new ArrayList<>();
            nums = new ArrayList<>();

            while (st.hasMoreTokens()) nums.add(Integer.parseInt(st.nextToken()));
            solve(0, 0, k);

            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
