import java.util.Arrays;

public class PRO12953 {
    public static int solution(int[] arr) {
        int lcm = Arrays.stream(arr).max().getAsInt() + 1;

        while (true) {
            boolean chk = true;

            for (int j : arr) {
                if (lcm % j != 0) {
                    chk = false;
                    break;
                }
            }

            if (!chk) lcm++;
            else break;
        }

        return lcm;
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {2, 6, 8, 14},
                {1, 2, 3}
        };

        Arrays.stream(arrs)
                .forEach(arr -> System.out.println(solution(arr)));
    }
}
