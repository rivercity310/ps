package programmers;

import java.util.*;

class Pro49994 {
    static class Move {
        int[] from;
        int[] to;

        public Move(int[] from, int[] to) {
            this.from = from;
            this.to = to;
        }
    }

    public int solution(String dirs) {
        List<Move> moves = new ArrayList<>();
        int[] from = new int[] { 0, 0 };
        int answer = 0;

        for (char c : dirs.toCharArray()) {
            int[] to = new int[2];

            if (c == 'L') {
                to[0] = from[0] - 1;
                to[1] = from[1];
            } else if (c == 'R') {
                to[0] = from[0] + 1;
                to[1] = from[1];
            } else if (c == 'U') {
                to[0] = from[0];
                to[1] = from[1] + 1;
            } else {
                to[0] = from[0];
                to[1] = from[1] - 1;
            }

            if (to[0] < -5 || to[0] > 5 || to[1] < -5 || to[1] > 5) continue;

            // from -> to or to -> from 경로가 list에 있으면 이미 간 길
            if (first_road(moves, from, to) && first_road(moves, to, from)) answer++;
            moves.add(new Move(from, to));
            from = to;
        }

        return answer;
    }

    boolean first_road(List<Move> moves, int[] from, int[] to) {
        for (Move m : moves) {
            int[] f = m.from;
            int[] t = m.to;

            if (f[0] == from[0] && f[1] == from[1] && t[0] == to[0] && t[1] == to[1]) {
                return false;
            }
        }

        return true;
    }
}