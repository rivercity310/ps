package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14267 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] grp;
    static int[] comp, boss;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boss = new int[N + 1];
        comp = new int[N + 1];
        grp = new List[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            grp[i] = new ArrayList<>();
            int k = Integer.parseInt(st.nextToken());
            boss[i] = k;
            grp[i].add(k);
            if (k != -1) grp[k].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int emp = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            comp[emp] += w;
        }

        solve(1);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(comp[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void solve(int curr) {
        for (int next : grp[curr]) {
            if (next != boss[curr]) {
                comp[next] += comp[curr];
                solve(next);
            }
        }
    }
}
