package wooa;

// 네트워크 복구 문제 (MST)
// 모든 네트워크가 연결되도록 끊어진 간선을 복구하려고 할 때 최소 비용 구하기

// 놓친 점: 굳이 마지막에 모든 정점이 연결되어 있는지 확인 안했어도 됐을 것 같다.

import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static class DSet {
        int[] parent;

        public DSet(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
                return parent[x];
            }

            return x;
        }

        void unionParent(int a, int b) {
            int ra = findParent(a);
            int rb = findParent(b);

            if (ra < rb) parent[rb] = ra;
            else parent[ra] = rb;
        }

        boolean isNotCycle(int a, int b) {
            return findParent(a) != findParent(b);
        }
    }

    static List<Edge> edges;
    static DSet dset;
    static int ans;

    static int solution(int[][] network, int[][] repair, int n) {
        edges = new ArrayList<>();
        dset = new DSet(n);
        ans = Integer.MAX_VALUE;

        for (int[] net : network) {
            edges.add(new Edge(net[0], net[1], 0));
        }

        for (int[] rep : repair) {
            edges.add(new Edge(rep[0], rep[1], rep[2]));
        }

        kr();
        return ans;
    }

    static void kr() {
        int total = 0;
        edges.sort((o1, o2) -> o1.cost - o2.cost);

        for (Edge edge : edges) {
            if (dset.isNotCycle(edge.start, edge.end)) {
                total += edge.cost;
                dset.unionParent(edge.start, edge.end);
            }
        }

        ans = Math.min(ans, total);
    }

    public static void main(String[] args) {
        int[][] network = { {1, 3}, {1, 2}, {4, 5}, {4, 6} };
        int[][] repair = { {1, 4, 4}, {2, 4, 3}, {3, 5, 2} };
        int n = 6;

        System.out.println(solution(network, repair, n));
    }
}
