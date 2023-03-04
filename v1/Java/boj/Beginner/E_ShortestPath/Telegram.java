package boj.Beginner.E_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Java로 다익스트라 구현하기...

public class Telegram {
    static StringTokenizer st;
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static List<Node>[] arr;

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static void solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[arr.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.end;
            int dist = tmp.weight;

            if (distance[now] < dist)
                continue;

            for (Node node : arr[now]) {
                int end_vtx = node.end;
                int weight = node.weight;
                int cost = distance[now] + weight;

                if (distance[end_vtx] > cost) {
                    distance[end_vtx] = cost;
                    pq.add(new Node(end_vtx, cost));
                }
            }
        }

        int cnt = 0;
        int max_val = -1;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] != 0 && distance[i] != Integer.MAX_VALUE) {
                cnt++;
                max_val = Math.max(max_val, distance[i]);
            }
        }

        System.out.println(cnt + " " + max_val);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        Arrays.setAll(arr, elem -> new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arr[x].add(new Node(y, z));
            arr[y].add(new Node(x, z));
        }

        solve(c);
    }
}
