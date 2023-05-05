package programmers;
import java.util.*;

class Pro17679 {
    public int solution(int m, int n, String[] board) {
        int ans = 0;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String tmp = board[i];

            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        while (true) {
            List<int[]> points = new ArrayList<>();
            boolean flag = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char ch = map[i][j];
                    int dft = 4;

                    // ch에 대해서 오른쪽, 아래, 오른쪽 대각선 아래 검사 --> 모두 일치하면 블럭이 된다
                    char right = map[i][j + 1];
                    char bottom = map[i + 1][j];
                    char bottomRight = map[i + 1][j + 1];

                    int[][] pts = { {i, j}, {i, j + 1}, {i + 1, j}, {i + 1, j + 1} };

                    if (ch != '@' && ch == right && right == bottom && bottom == bottomRight) {
                        for (int[] p : pts) {
                            boolean cont = false;
                            for (int[] pp : points) {
                                if (pp[0] == p[0] && pp[1] == p[1]) {
                                    cont = true;
                                    break;
                                }
                            }
                            if (cont) dft--;
                            else points.add(p);
                        }

                        ans += dft;
                        flag = true;
                    }
                }
            }

            if (!flag) break;

            for (int[] pt : points) {
                int row = pt[0];
                int col = pt[1];
                map[row][col] = '@';
            }

            // '@' : 빈칸
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] == '@') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '@') {
                                map[i][j] = map[k][j];
                                map[k][j] = '@';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
