package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1865 {
    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int TC, N, M, W, S, E, T, MV;
    static ArrayList<Edge> grp;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        MV = (int) 1e9;
        TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            grp = new ArrayList<>();
            dist = new int[N + 1];

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    grp.add(new Edge(S, E, T));
                    grp.add(new Edge(E, S, T));
                } else {
                    grp.add(new Edge(S, E, -T));
                }
            }

            sb.append(bf() ? "YES" : "NO");
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean bf() {
        Arrays.fill(dist, MV);
        dist[1] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (Edge eg : grp) {
                if (dist[eg.end] > dist[eg.start] + eg.cost) {
                    dist[eg.end] = dist[eg.start] + eg.cost;
                    update = true;
                }
            }

            if (!update) break;
        }

        if (update) {
            for (Edge eg : grp) {
                if (dist[eg.end] > dist[eg.start] + eg.cost) {
                    return true;
                }
            }
        }

        return false;
    }
}
