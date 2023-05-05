package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1967 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, maxDist, maxNode;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> grp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        grp = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grp.get(a).add(new int[] { b, c });
            grp.get(b).add(new int[] { a, c });
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(maxNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int sum) {
        visited[node] = true;

        if (sum > maxDist) {
            maxNode = node;
            maxDist = sum;
        }

        for (int[] tmp : grp.get(node)) {
            if (!visited[tmp[0]]) {
                visited[tmp[0]] = true;
                dfs(tmp[0], sum + tmp[1]);
            }
        }
    }
}
