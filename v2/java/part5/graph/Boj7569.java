package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj7569 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final Deque<Quadra> dq = new ArrayDeque<>();
    static StringTokenizer st;
    static int N, M, H, ans, minus;
    static int[][][] box;

    static class Quadra {
        int x, y, h, days;

        public Quadra(int x, int y, int h, int days) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.days = days;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    if (k == -1) minus++;
                    else if (k == 1) dq.add(new Quadra(i, j, h, 0));
                    box[h][i][j] = k;
                }
            }
        }

        if (H * N * M - minus == dq.size()) System.out.println(0);
        else if (solve()) System.out.println(ans);
        else System.out.println(-1);
    }

    static boolean solve() {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!dq.isEmpty()) {
            Quadra quadra = dq.removeFirst();
            ans = Math.max(ans, quadra.days);

            for (int dh = -1; dh <= 1; dh++) {
                if (dh == 0) {
                    for (int i = 0; i < 4; i++) {
                        int vx = dx[i] + quadra.x;
                        int vy = dy[i] + quadra.y;
                        int vh = quadra.h;

                        if (vx < 0 || vy < 0 || vx >= N || vy >= M)
                            continue;

                        if (box[vh][vx][vy] == 0) {
                            box[vh][vx][vy] = 1;
                            dq.add(new Quadra(vx, vy, vh, quadra.days + 1));
                        }
                    }
                }

                else {
                    int vx = quadra.x;
                    int vy = quadra.y;
                    int vh = quadra.h + dh;

                    if (vh < 0 || vh >= H)
                        continue;

                    if (box[vh][vx][vy] == 0) {
                        box[vh][vx][vy] = 1;
                        dq.add(new Quadra(vx, vy, vh, quadra.days + 1));
                    }
                }
            }
        }

        for (int a = 0; a < H; a++)
            for (int b = 0; b < N; b++)
                for (int c = 0; c < M; c++)
                    if (box[a][b][c] == 0)
                        return false;

        return true;
    }
}
