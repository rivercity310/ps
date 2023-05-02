package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2251 {
    static class State {
        int[] s;

        public State(int[] state) {
            this.s = new int[3];
            System.arraycopy(state, 0, this.s, 0, 3);
        }

        public State move(int from, int to, int[] limit) {
            int[] st = new int[] { s[0], s[1], s[2] };

            if (s[from] + s[to] >= limit[to]) {
                st[from] -= limit[to] - s[to];
                st[to] = limit[to];
            } else {
                st[to] += st[from];
                st[from] = 0;
            }

            return new State(st);
        }
    }

    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int[] limit;
    static boolean[][][] visited;
    static boolean[] possible;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        limit = new int[st.countTokens()];

        for (int i = 0; i < limit.length; i++)
            limit[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[limit[0] + 1][limit[1] + 1][limit[2] + 1];
        possible = new boolean[limit[2] + 1];

        dfs(0, 0, limit[2]);

        for (int i = 0; i <= limit[2]; i++)
            if (possible[i])
                sb.append(i).append(' ');

        System.out.println(sb);
    }

    static void dfs(int a, int b, int c) {
        Stack<State> stk = new Stack<>();
        stk.push(new State(new int[] { a, b, c }));
        visited[a][b][c] = true;

        while (!stk.isEmpty()) {
            State st = stk.pop();
            if (st.s[0] == 0) possible[st.s[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    State nst = st.move(from, to, limit);

                    if (!visited[nst.s[0]][nst.s[1]][nst.s[2]]) {
                        visited[nst.s[0]][nst.s[1]][nst.s[2]] = true;
                        stk.push(nst);
                    }
                }
            }
        }
    }
}
