package boj.Beginner.E_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13549 {
    static StringTokenizer st;
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static int n, k, m;
    static List<Integer>[] grp;

    static class Node implements Comparable<Node> {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    private static int solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[grp.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[n] = 0;
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.end;
            int dist = tmp.dist;

            if (distance[now] < dist)
                continue;

            for (int k : grp[now]) {
                if (k >= 2 * m)
                    continue;

                int weight = k == now * 2 ? 0 : 1;
                int cost = distance[now] + weight;

                if (distance[k] > cost) {
                    distance[k] = cost;
                    pq.add(new Node(k, cost));
                }
            }
        }

        return distance[k];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.max(n, k);

        grp = new ArrayList[2 * m];
        Arrays.setAll(grp, elem -> new ArrayList<>());

        grp[0].add(1);
        grp[1].add(2);
        grp[1].add(0);

        for (int i = 2; i < grp.length; i++) {
            grp[i].add(i - 1);
            grp[i].add(i + 1);
            grp[i].add(2 * i);
        }

        System.out.print(solve());
        br.close();
    }
}
