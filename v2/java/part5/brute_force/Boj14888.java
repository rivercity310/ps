package part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums, ops;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        solve(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0) {
                ops[i]--;

                switch (i) {
                    case 0 : solve(depth + 1, sum + nums[depth]); break;
                    case 1 : solve(depth + 1, sum - nums[depth]); break;
                    case 2 : solve(depth + 1, sum * nums[depth]); break;
                    case 3 : solve(depth + 1, sum / nums[depth]); break;
                }

                ops[i]++;
            }
        }
    }
}
