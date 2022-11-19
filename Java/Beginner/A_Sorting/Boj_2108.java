package Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2108 {
    static final int None = Integer.MIN_VALUE;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static long get_avg(int n, int[] nums) {
        return Math.round((double)Arrays.stream(nums).sum() / n);
    }

    private static int get_middle(int n, int[] nums) {
        return nums[n / 2];
    }

    private static int get_frequency(int n, int[] nums) {
        if (n == 1)
            return nums[0];

        int size = 4001;
        int[] fq_minus = new int[size];
        int[] fq_plus = new int[size];

        for (int k : nums) {
            if (k < 0) fq_minus[-k]++;
            else fq_plus[k]++;
        }

        int fq_minus_max = Arrays.stream(fq_minus).max().getAsInt();
        int fq_plus_max = Arrays.stream(fq_plus).max().getAsInt();
        int most_val = Math.max(fq_minus_max, fq_plus_max);

        boolean is_minus = false;
        int is_second = 0;
        int tmp = None;

        for (int i = size - 1; i > 0; i--) {
            if (fq_minus[i] == most_val) {
                if (is_second == 1)
                    return -i;      // 두번째 등장한 최빈값 -i를 반환한다

                is_minus = true;
                tmp = i;
                is_second++;
            }
        }

        for (int i = 0; i < size; i++) {
            if (fq_plus[i] == most_val) {
                if (is_second == 1)
                    return i;       // 두번쨰 등장한 최빈값 i를 반환한다

                is_minus = false;
                tmp = i;
                is_second++;
            }
        }

        if (is_minus) return -tmp;      // 두번 중복되지 않고 가장 빈도 높은 값이 음수쪽에 있으면 -tmp
        else return tmp;                // 양수쪽에 존재하면 tmp를 반환한다
    }

    private static int get_range(int n, int[] nums) {
        return nums[n - 1] - nums[0];
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        System.out.println(get_avg(n, nums));
        System.out.println(get_middle(n, nums));
        System.out.println(get_frequency(n, nums));
        System.out.println(get_range(n, nums));
    }
}
