package boj.Beginner.E_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1753 {
    static StringTokenizer st;
    static List<Node>[] grp;

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

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[grp.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

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

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        grp = new ArrayList[V + 1];
        Arrays.setAll(grp, elem -> new ArrayList<>());

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            grp[u].add(new Node(v, w));
        }

        int[] distance = dijkstra(start);
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
