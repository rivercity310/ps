package part5.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1932 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Integer>> tri;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tri = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tri.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) tri.get(i).add(Integer.parseInt(st.nextToken()));
        }

        solve();
    }

    static void solve() {
        for (int i = 1; i < N; i++) {
            tri.get(i).set(0, tri.get(i).get(0) + tri.get(i - 1).get(0));

            for (int j = 1; j < i; j++) {
                int max = Math.max(tri.get(i - 1).get(j - 1), tri.get(i - 1).get(j));
                tri.get(i).set(j, tri.get(i).get(j) + max);
            }

            tri.get(i).set(tri.get(i).size() - 1, tri.get(i).get(tri.get(i).size() - 1) + tri.get(i - 1).get(tri.get(i - 1).size() - 1));
        }

        int max = 0;

        for (int i = 0; i < tri.get(N - 1).size(); i++)
            max = Math.max(max, tri.get(N - 1).get(i));

        System.out.println(max);
    }
}
