package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1253 {
    static BufferedReader br;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);
        solve();
    }

    static void solve() {
        int good = 0;

        for (int i = 0; i < N; i++) {
            if (sch(i)) {
                good++;
            }
        }

        System.out.println(good);
    }

    static boolean sch(int idx) {
        int left = 0;
        int right = N - 1;
        int target = arr[idx];

        while (left < right) {
            if (left == idx) left++;
            else if (right == idx) right--;
            else {
                int sum = arr[left] + arr[right];
                if (sum == target) return true;
                else if (sum > target) right--;
                else left++;
            }
        }

        return false;
    }
}
