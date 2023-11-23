package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14888 {
    static BufferedReader br;
    static int N, min, max;
    static int[] ops, arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int idx, int sum) {
        if (idx == N - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i] -= 1;
                solve(idx + 1, calc(i, sum, arr[idx + 1]));
                ops[i] += 1;
            }
        }
    }

    private static int calc(int op, int sum, int num) {
        if (op == 0) sum += num;
        else if (op == 1) sum -= num;
        else if (op == 2) sum *= num;
        else sum /= num;
        return sum;
    }
}
