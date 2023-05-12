package random;

import java.util.*;
import java.io.*;

public class Boj1389 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M, min, minP;
    static ArrayList<ArrayList<Integer>> grp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grp = new ArrayList<>();
        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;
        minP = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) {
            grp.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grp.get(a).add(b);
            grp.get(b).add(a);
        }

        for (int i = N - 1; i >= 1; i--) {
            solve(i);
            Arrays.fill(visited, false);
        }

        System.out.println(minP);
    }

    static void solve(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start, 1 });
        visited[start] = true;
        int kb = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int now = tmp[0];
            int k = tmp[1];
            int in = 0;

            for (int next : grp.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] { next, k + 1 });
                    in++;
                }
            }

            kb += in * k;
        }

        if (min >= kb) {
            min = kb;
            minP = start;
        }
    }
}