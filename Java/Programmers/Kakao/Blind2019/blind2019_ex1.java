package Programmers.Kakao.Blind2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class blind2019_ex1 {
    public static class Solution {
        static class Pair implements Comparable<Pair> {
            double fail;
            int stage;

            public Pair(double fail, int stage) {
                this.fail = fail;
                this.stage = stage;
            }

            @Override
            public int compareTo(Pair pair) {
                if (this.fail == pair.fail)
                    return this.stage - pair.stage;

                return (pair.fail - this.fail) > 0 ? 1 : (pair.fail - this.fail) == 0 ? 0 : -1;
            }
        }

        public int[] solution(int N, int[] stages) {
            ArrayList<Pair> arr = new ArrayList<>();

            for (int stage = 1; stage <= N; stage++) {
                int done = 0;
                int challenging = 0;

                for (int now : stages) {
                    if (now >= stage) done++;
                    if (now == stage) challenging++;
                }

                double fail = (challenging == 0) ? 0 : challenging / (double) done;
                arr.add(new Pair(fail, stage));
            }

            Collections.sort(arr);
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < arr.size(); i++)
                ans.add(arr.get(i).stage);

            return ans.stream().mapToInt(i -> i).toArray();
        }
    }
    public static void main(String[] args) {
        int[][] test = { {2, 1, 2, 6, 2, 4, 3, 3}, {4, 4, 4, 4, 4}, {1, 1, 1, 1, 1, 1} };
        int[] N = { 5, 4, 1 };

        for (int i = 0; i < test.length; i++) {
            int[] rst = new Solution().solution(N[i], test[i]);
            for (int k : rst) System.out.print(k + " ");
            System.out.println();
        }
    }
}
