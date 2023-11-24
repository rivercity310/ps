package topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2252 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] inDegree, result;
    static List<Integer>[] grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        result = new int[N + 1];
        grp = new List[N + 1];

        for (int i = 1; i <= N; i++)
            grp[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            grp[u].add(v);
            inDegree[v]++;
        }

        solve();
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0)
                q.add(i);

        int idx = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            result[idx++] = now;

            for (int next : grp[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    q.add(next);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}
