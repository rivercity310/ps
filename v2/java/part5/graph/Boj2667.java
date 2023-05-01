package part5.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj2667 {
    static BufferedReader br;
    static StringBuffer sb;
    static int N;
    static int[][] grp;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        ans = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        grp = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < N; j++) {
                grp[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grp[i][j] == 1) {
                    ans.add(solve(i, j));
                }
            }
        }

        ans.sort((o1, o2) -> o1 - o2);
        sb.append(ans.size()).append('\n');
        ans.forEach(i -> sb.append(i).append('\n'));
        System.out.print(sb);
    }

    static int solve(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N) return 0;
        if (grp[i][j] == 0) return 0;
        grp[i][j] = 0;

        return solve(i + 1, j)
                + solve(i - 1, j)
                + solve(i, j + 1)
                + solve(i, j - 1)
                + 1;
    }
}
