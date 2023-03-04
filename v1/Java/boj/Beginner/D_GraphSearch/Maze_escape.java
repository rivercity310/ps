package boj.Beginner.D_GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_escape {
    static StringTokenizer st;
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static int[][] grp;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print_arr(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.printf("%-5d", grp[i][j]);
            System.out.println();
        }
    }

    private static void solve(int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            int x = tmp.x;
            int y = tmp.y;

            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || ty < 0 || tx >= n || ty >= m)
                    continue;

                if (grp[tx][ty] == 1) {
                    grp[tx][ty] = grp[x][y] + 1;
                    q.add(new Node(tx, ty));
                }

                /*
                - 종료조건
                if (tx == n - 1 && ty == m - 1) {
                    System.out.println(grp[tx][ty]);
                    return;
                }
                */
            }
        }

        grp[0][0] = 1;
        System.out.println();
        print_arr(n, m);
        System.out.println();

        System.out.println(grp[n - 1][m - 1]);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grp = new int[n][m];

        // 붙어있는 숫자 입력받기 : 문자열로 입력받은뒤 스트링 인덱스와 아스키 코드를 이용하여 정수로 변
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++)
                grp[i][j] = str.charAt(j) - '0';
        }

        System.out.println("[ 그래프 입력 완료 ]");
        print_arr(n, m);

        solve(n, m);
    }
}
