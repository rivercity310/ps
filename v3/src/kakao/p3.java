package kakao;

import java.util.*;

class p3 {
    static int N;
    static int[][] d;
    static int[] pick;
    static double max;
    static int[] ans;
    static List<Integer> as;
    static List<Integer> bs;

    public int[] solution(int[][] dice) {
        N = dice.length;
        d = dice;
        pick = new int[N / 2];
        ans = new int[N / 2];
        solve(0, 0);
        return ans;
    }

    static void getSum(int[][] arr, int depth, int sum, int type) {
        if (depth == N / 2) {
            if (type == 0) as.add(sum);
            else bs.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            getSum(arr, depth + 1, sum + arr[depth][i], type);
        }
    }

    static void solve(int dnum, int depth) {
        if (depth == N / 2) {
            int aidx = 0;
            int bidx = 0;
            int[][] adice = new int[N / 2][6];
            int[][] bdice = new int[N / 2][6];
            as = new LinkedList<>();
            bs = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                boolean in = false;

                for (int j = 0; j < N / 2; j++) {
                    if (pick[j] == i) {
                        in = true;
                        break;
                    }
                }

                if (in) adice[aidx++] = d[i];
                else bdice[bidx++] = d[i];
            }

            getSum(adice, 0, 0, 0);
            getSum(bdice, 0, 0, 1);

            int[] stat = new int[3];
            for (int i = 0; i < as.size(); i++) {
                for (int j = 0; j < bs.size(); j++) {
                    int a = as.get(i);
                    int b = bs.get(j);

                    if (a > b) stat[0]++;
                    else if (a == b) stat[1]++;
                    else stat[2]++;
                }
            }

            double prob = (stat[0]) / (double)(stat[0] + stat[1] + stat[2]);
            if (prob > max) {
                max = prob;
                for (int i = 0; i < N / 2; i++) {
                    ans[i] = pick[i] + 1;
                }
            }

            return;
        }

        if (dnum >= N) {
            return;
        }

        // 현재 주사위를 선택하는 경우
        pick[depth] = dnum;
        solve(dnum + 1, depth + 1);

        // 현재 주사위를 선택하지 않는 경우
        solve(dnum + 1, depth);
    }
}