package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++)
            parent[i] = i;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                up(a, b);
            }
            else if (op == 1) {
                if (fp(a) == fp(b)) sb.append("YES");
                else sb.append("NO");
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    private static void up(int a, int b) {
        int ra = fp(a);
        int rb = fp(b);

        if (ra > rb) parent[ra] = rb;
        else parent[rb] = ra;
    }

    private static int fp(int x) {
        if (x != parent[x]) {
            return parent[x] = fp(parent[x]);
        }

        return x;
    }
}
