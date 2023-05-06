package wooa;

// 1. 돈나오는 상자 (간단한 그리디)
// 놓친점 : boxes를 정렬한 후, 10만 초과가 나오는 이후로는 더 순회할 필요가 없었음..

import java.util.Arrays;

public class Ex1 {
    static int solution(int[] boxes, int m, int k) {
        int ans = m;

        Arrays.sort(boxes);

        for (int day = 1; day <= k; day++) {
            int max = 0;

            for (int box : boxes) {
                // 만원 당 box 이자 (10만원이 넘으면 안된다)
                int tmp = ans / 10000;
                int output = tmp * box;

                if (output <= 100000) {
                    max = Math.max(max, output);
                } else {
                    break;
                }
            }

            System.out.println("이자 : " + max);
            ans += max;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] boxes = { 1000, 8520, 4320, 3300 };
        int m = 100000;
        int k = 5;
        System.out.println(solution(boxes, m, k));
    }
}
