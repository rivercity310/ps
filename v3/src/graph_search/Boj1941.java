package graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1941 {
    static BufferedReader br;
    static int N = 5, ans;
    static int[] students;
    static int[] pick;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        students = new int[25];
        pick = new int[7];

        for (int i = 0, cnt = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                if (ch[j] == 'Y') students[cnt] = 0;
                else students[cnt] = 1;
                cnt++;
            }
        }

        solve();
    }

    private static void solve() {
        // 학생 7명의 조합을 구한다 (25C7)
        // 구한 순열을 다음 조건으로 검증한다
        // - 1. 이다솜파가 4명 이상
        // - 2. 7명 학생이 모두 인접
        // 위 조건을 통과하면 정답 카운팅
        createPermutation(0, 0);
        System.out.println(ans);
    }

    private static void createPermutation(int snum, int depth) {
        // Base case
        if (depth == 7) {
            if (!overFour()) return;
            visited = new boolean[7];
            if (isAllNearby(0) != 7) return;
            ans++;
            return;
        }

        if (snum >= 25) return;

        // Recursive case
        // 1. 현재 학생을 뽑는 경우
        pick[depth++] = snum;
        createPermutation(snum + 1, depth);
        depth--;

        // 2. 현재 학생을 뽑지 않는 경우
        createPermutation(snum + 1, depth);
    }

    private static boolean overFour() {
        int cnt = 0;
        for (int i = 0; i < 7; i++) cnt += students[pick[i]];
        return cnt >= 4;
    }

    private static int isAllNearby(int pnum) {
        visited[pnum] = true;

        int cnt = 1;
        int me = pick[pnum];

        for (int i = 1; i < 7; i++) {
            int you = pick[i];

            if (!visited[i] && nearbyWith(me, you)) {
                cnt += isAllNearby(i);
            }
        }

        return cnt;
    }

    private static boolean nearbyWith(int me, int you) {
        int diff = Math.abs(me - you);
        int max = Math.max(me, you);

        if (diff == 1 && max % 5 != 0) return true;
        if (diff == 5) return true;
        return false;
    }
}
