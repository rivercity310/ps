package wooa;

// 지뢰찾기 (DFS/BFS)
// - 1. 첫시도에 지뢰를 누르면 해당 좌표 X, 나머지 그대로 리턴
// - 2. 현재 위치 주변 8개 방향에 지뢰가 있으면 그 개수를 버튼에 표시하고 해당 좌표만 오픈 후 개수 표시
// - 2-1. 지뢰가 없다면 인접한 8개 방향에 대해 재귀를 수행하고 'B' 표시
// ===> x, y를 눌렀을 때 결과를 리턴

import java.util.*;

public class Ex3 {
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> mines;

    static String[] solution(String[] board, int x, int y) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        mines = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            String tmp = board[i];
            for (int j = 0; j < tmp.length(); j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'M') mines.add(new int[] { i, j });
            }
        }

        // 첫 시도에 지뢰 눌렀을 때 예외처리
        if (map[x][y] == 'M') {
            map[x][y] = 'X';
            return buildBoard(map);
        }

        dfs(x, y);

        for (int[] m : mines) {
            map[m[0]][m[1]] = 'E';
        }

        return buildBoard(map);
    }

    static void dfs(int x, int y) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[] { x, y });
        visited[x][y] = true;
        map[x][y] = 'B';

        int[][] points = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
                {0, 1}, {1, -1}, {1, 0}, {1, 1} };

        while (!stk.isEmpty()) {
            int[] tmp = stk.pop();
            int nx = tmp[0];
            int ny = tmp[1];
            int mine = 0;
            Queue<int[]> q = new LinkedList<>();

            for (int[] point : points) {
                int tx = nx + point[0];
                int ty = ny + point[1];

                if (tx < 0 || ty < 0 || tx >= map.length || ty >= map[0].length) continue;
                if (visited[tx][ty]) continue;
                if (map[tx][ty] == 'M') mine++;
                else q.add(new int[] { tx, ty });
            }

            // 지뢰가 주변에 있으면 개수만 표시
            if (mine > 0) {
                map[nx][ny] = String.valueOf(mine).charAt(0);
            } else {
                while (!q.isEmpty()) {
                    int[] tp = q.poll();
                    map[tp[0]][tp[1]] = 'B';
                    visited[tp[0]][tp[1]] = true;
                    dfs(tp[0], tp[1]);
                }
            }
        }
    }

    static String[] buildBoard(char[][] map) {
        String[] board = new String[map.length];
        for (int i = 0; i < board.length; i++) board[i] = new String(map[i]);
        return board;
    }

    public static void main(String[] args) {
        String[] board = { "EEEME", "EEEEE", "EEMEE", "EEEEE", "MEEEE" };
        String[] ans = solution(board, 4, 4);
        for (String an : ans) System.out.println(an);
    }
}
