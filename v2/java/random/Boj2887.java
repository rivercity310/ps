package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2887 {
    static class Point {
        int x, y, z, idx;

        public Point(int x, int y, int z, int idx) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }
    }

    static class Edge {
        int start, end, dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    static class DSet {
        int[] parent;

        public DSet(int n) {
            parent = new int[n];
            for (int i = 1; i < n; i++)
                parent[i] = i;
        }

        public int findParent(int x) {
            if (x != parent[x]) {
                parent[x] = findParent(parent[x]);
                return parent[x];
            }

            return x;
        }

        public void unionParent(int a, int b) {
            int ra = findParent(a);
            int rb = findParent(b);

            if (ra < rb) parent[rb] = ra;
            else parent[ra] = rb;
        }

        public boolean isNotCycle(int a, int b) {
            return findParent(a) != findParent(b);
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int N, ans;
    static ArrayList<Edge> planet;
    static ArrayList<Point> points;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        planet = new ArrayList<>();
        points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            points.add(new Point(a, b, c, i));
        }

        points.sort((p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(points.get(i).x - points.get(i + 1).x);
            planet.add(new Edge(points.get(i).idx, points.get(i + 1).idx, dist));
        }

        points.sort((p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(points.get(i).y - points.get(i + 1).y);
            planet.add(new Edge(points.get(i).idx, points.get(i + 1).idx, dist));
        }

        points.sort((p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < N - 1; i++) {
            int dist = Math.abs(points.get(i).z - points.get(i + 1).z);
            planet.add(new Edge(points.get(i).idx, points.get(i + 1).idx, dist));
        }

        kr();
        System.out.println(ans);
    }

    static void kr() {
        int s = 0;
        DSet dset = new DSet(planet.size());
        planet.sort((o1, o2) -> o1.dist - o2.dist);

        for (Edge nd : planet) {
            if (dset.isNotCycle(nd.start, nd.end)) {
                s += nd.dist;
                dset.unionParent(nd.start, nd.end);
            }
        }

        ans = Math.min(ans, s);
    }
}
