package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10816 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M;
    static Map<Integer, Integer> m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        m = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            m.merge(k, 1, Integer::sum);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());
            sb.append(m.get(k) == null ? 0 : m.get(k)).append(' ');
        }

        System.out.println(sb);
    }
}
