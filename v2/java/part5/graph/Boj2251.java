package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2251 {
    static class State {
        private final int[] state;
        State(int[] state) {
            this.state = new int[3];
            System.arraycopy(state, 0, this.state, 0, 3);
        }

        State move(int from, int to, int[] limit) {
            int[] newState = new int[] { state[0], state[1], state[2] };

            if (state[from] + state[to] >= limit[to]) {
                newState[from] -= limit[to] - state[to];
                newState[to] = limit[to];
            } else {
                newState[to] += newState[from];
                newState[from] = 0;
            }

            return new State(newState);
        }

    }

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] limit;
    static boolean[][][] visit;
    static boolean[] possible;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        limit = new int[3];

        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[limit[0] + 1][limit[1] + 1][limit[2] + 1];
        possible = new boolean[limit[2] + 1];

        bfs(0, 0, limit[2]);

        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i]) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(new int[] { x1, x2, x3 }));

        visit[x1][x2][x3] = true;

        while (!q.isEmpty()) {
            State st = q.poll();
            if (st.state[0] == 0) possible[st.state[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);

                    if (!visit[nxt.state[0]][nxt.state[1]][nxt.state[2]]) {
                        visit[nxt.state[0]][nxt.state[1]][nxt.state[2]] = true;
                        q.add(nxt);
                    }
                }
            }
        }
    }
}
