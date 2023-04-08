package part5.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N = 3, A = [2, 3, 1]
// P = (0, 1, 2), (0, 2, 1), (1, 0, 2), (1, 2, 0), (2, 0, 1), (2, 1, 0)
// B = (2, 3, 1), (2, 1, 3), (3, 2, 1), (1, 2, 3), (3, 1, 2), (1, 3, 2)

// A[0] = B[P[0]] ---> 2 = B[P[0]]
// A[1] = B[P[1]] ---> 3 = B[P[1]]
// A[2] = B[P[2]] ---> 1 = B[P[2]]

// 수열 P를 적용한 결과인 배열 B가 비내림차순이 되게 하는 수열 P를 사전순 앞서는 1개 출력
public class Boj1015 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N;
    static int[] P;
    static Pair[] B;

    static class Pair implements Comparable<Pair> {
        public int num, idx;

        @Override
        public int compareTo(Pair other) {
            if (this.num == other.num)
                return this.idx - other.idx;
            return this.num - other.num;
        }

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        B = new Pair[N];
        P = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = new Pair(num, i);
        }

        Arrays.sort(B);
        for (int i = 0; i < N; i++) P[B[i].idx] = i;
        for (int i = 0; i < N; i++) sb.append(P[i]).append(' ');
        System.out.print(sb);
    }
}
