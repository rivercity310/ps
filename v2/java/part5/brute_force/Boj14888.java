package part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums, ops;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        solve(nums[0], 0);

        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int sum, int depth) {
        if (depth == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                solve(calc(i, sum, nums[depth + 1]), depth + 1);
                ops[i]++;
            }
        }
    }

    static int calc(int op, int sum, int num) {
        if (op == 0) sum += num;
        else if (op == 1) sum -= num;
        else if (op == 2) sum *= num;
        else sum /= num;
        return sum;
    }
}
