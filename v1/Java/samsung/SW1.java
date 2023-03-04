package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW1 {
    static int T;
    static int R;
    static int C;
    static int max;
    static char[][] map;
    static boolean[][] visited;
    static Set<Character> set;
    static int[] rows = {-1, 1, 0, 0};
    static int[] cols = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];
            set = new HashSet<>();

            for (int j = 0; j < R; j++) {
                map[j] = br.readLine().toCharArray();
            }

            if (R == 1 && C == 1) {
                sb.append("#").append(i).append(' ');
                sb.append(1).append('\n');
            }
            else {
                set.add(map[0][0]);
                visited[0][0] = true;
                max = Integer.MIN_VALUE;
                dfs(0, 0);

                sb.append("#").append(i).append(' ');
                sb.append(max).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int dr = r + rows[i];
            int dc = c + cols[i];

            if (0 <= dr && 0 <= dc && dr < R && dc < C && !visited[dr][dc] && !set.contains(map[dr][dc])) {
                visited[dr][dc] = true;
                set.add(map[dr][dc]);
                dfs(dr, dc);
                max = Integer.max(max, set.size());
                set.remove(map[dr][dc]);
                visited[dr][dc] = false;
            }
        }
    }
}
