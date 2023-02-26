import java.util.Arrays;
import java.util.Comparator;

public class PRO42861 {
    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int findParent(int x) {
            if (parent[x] != x) return findParent(parent[x]);
            return x;
        }

        public void unionParent(int a, int b) {
            int ra = findParent(a);
            int rb = findParent(b);

            if (ra < rb) parent[rb] = ra;
            else parent[ra] = rb;
        }
    }


    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int ans = 0;
        UnionFind uf = new UnionFind(n);

        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];

            if (uf.findParent(start) != uf.findParent(end)) {
                uf.unionParent(start, end);
                ans += weight;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {
                { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 },
                { 1, 3, 1 }, { 2, 3, 8 }
        };

        System.out.println(solution(n, costs));
    }
}
