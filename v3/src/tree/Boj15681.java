package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 트리와 쿼리 */
public class Boj15681 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, R, Q;
    static List<Integer>[] grp;
    static int[] subSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        grp = new List[N + 1];
        subSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            grp[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grp[a].add(b);
            grp[b].add(a);
        }

        calcSubTreeSize(R);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(calcSubTreeSize(q));
        }
    }

    private static int calcSubTreeSize(int curr) {
        if (subSize[curr] > 0) return subSize[curr];

        visited[curr] = true;
        int result = 1;

        for (int next : grp[curr]) {
            if (!visited[next]) {
                result += calcSubTreeSize(next);
            }
        }

        return subSize[curr] = result;
    }
}