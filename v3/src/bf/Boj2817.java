package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2817 {
    static class Score {
        int idx;
        double score;

        public Score(int idx, double score) {
            this.idx = idx;
            this.score = score;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int[] scoreCount;
    static boolean[] validCandidate;
    static double[] staffVote;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int whole = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        double cut = whole * 0.05;

        scoreCount = new int[26];
        validCandidate = new boolean[26];
        staffVote = new double[26];
        int candCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char staff = st.nextToken().charAt(0);
            double vote = Double.parseDouble(st.nextToken());

            if (cut <= vote) {
                int index = staff - 'A';
                validCandidate[index] = true;
                staffVote[index] = vote;
                candCnt++;
            }
        }

        Score[] scores = new Score[candCnt * 14];
        int scoreIndex = 0;

        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]) {
                for (int j = 1; j <= 14; j++) {
                    scores[scoreIndex++] =
                            new Score(i, (double)staffVote[i] / j);
                }
            }
        }

        Arrays.sort(scores, (a, b) -> Double.compare(b.score, a.score));

        for (int i = 0; i < 14; i++) {
            Score score = scores[i];
            scoreCount[score.idx]++;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]) {
                sb.append((char)('A' + i))
                        .append(' ')
                        .append(scoreCount[i])
                        .append('\n');
            }
        }

        System.out.print(sb);
    }
}
