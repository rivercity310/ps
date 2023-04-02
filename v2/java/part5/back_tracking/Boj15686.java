package part5.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final List<int[]> home = new ArrayList<>();
    static final List<int[]> chicken = new ArrayList<>();
    static StringTokenizer st;
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) home.add(new int[] { i, j });
                else if (t == 2) chicken.add(new int[] { i, j });
            }
        }

        selected = new boolean[chicken.size()];
        solve(0, 0);
        System.out.println(ans);
    }

    // 살릴 치킨집 최대 M개 골랐을 때, 도시의 치킨 거리의 최솟값 구하기
    static void solve(int start, int k) {
        if (k == M) {
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (selected[j]) {
                        int dist = getChickenDistance(home.get(i), chicken.get(j));
                        tmp = Math.min(dist, tmp);
                    }
                }

                sum += tmp;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                solve(i + 1, k + 1);
                selected[i] = false;
            }
        }
    }

    // 특정 집에서 가장 가까운 치킨집과의 거리 반환
    static int getChickenDistance(int[] h, int[] c) {
        return Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
    }
}
