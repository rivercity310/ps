package Beginner.E_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1916 {

    static StringTokenizer st;
    static List<Node>[] grp;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[grp.length];
        Arrays.fill(distance, INF);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.end;
            int dist = tmp.weight;

            if (distance[now] < dist)
                continue;

            for (Node node : grp[now]) {
                int end_vertex = node.end;
                int weight = node.weight;
                int cost = distance[now] + weight;

                if (distance[end_vertex] > cost) {
                    distance[end_vertex] = cost;
                    pq.add(new Node(end_vertex, cost));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        grp = new ArrayList[n + 1];
        Arrays.setAll(grp, elem -> new ArrayList<>());
        /*
        for (int i = 0; i <= n; i++)
            grp[i] = new ArrayList<>();
        */

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            grp[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(start, end));

        br.close();
    }
}
