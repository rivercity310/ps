package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj7576 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final Deque<Triple> dq = new ArrayDeque<>();
    static int[][] box;
    static StringTokenizer st;
    static int N, M, ans, minus;

    static class Triple {
        int x, y, days;

        public Triple(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) dq.add(new Triple(i, j, 0));
                else if (k == -1) minus++;
                box[i][j] = k;
            }
        }

        if (dq.size() == N * M - minus) System.out.println(0);
        else if (solve()) System.out.println(ans);
        else System.out.println(-1);
    }

    static boolean solve() {
        final int[] dx = { -1, 1, 0, 0 };
        final int[] dy = { 0, 0, -1, 1 };

        while (!dq.isEmpty()) {
            Triple t = dq.removeFirst();
            ans = Math.max(t.days, ans);

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (x < 0 || y < 0 || x >= M || y >= N)
                    continue;

                if (box[x][y] == 0) {
                    box[x][y] = 1;
                    dq.add(new Triple(x, y, t.days + 1));
                }
            }
        }

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (box[i][j] == 0)
                    return false;

        return true;
    }
}
