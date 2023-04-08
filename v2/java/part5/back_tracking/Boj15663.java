package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15663 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N, M;
    static int[] nums, ans;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];
        nums = new int[N];
        selected = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        solve(0);
        System.out.print(sb);
    }

    static void solve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(nums[ans[i]]).append(' ');
            sb.append('\n');
            return;
        }

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (!selected[i] && tmp != nums[i]) {
                ans[depth] = i;
                tmp = nums[i];
                selected[i] = true;
                solve(depth + 1);
                selected[i] = false;
            }
        }
    }
}
