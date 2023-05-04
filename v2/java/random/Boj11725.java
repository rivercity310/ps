package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11725 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Integer>> grp;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        grp = new ArrayList<>();
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            grp.get(n).add(m);
            grp.get(m).add(n);
        }

        dfs(1);

        for (int i = 2; i <= N; i++)
            sb.append(ans[i]).append('\n');

        System.out.print(sb);
    }

    static void dfs(int parent) {
        visited[parent] = true;

        for (int child : grp.get(parent)) {
            if (!visited[child]) {
                visited[child] = true;
                ans[child] = parent;
                dfs(child);
            }
        }
    }
}
