package part5.sorting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Boj11652 {
    static BufferedReader br;
    static int N;
    static Map<Long, Integer> m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        m = new TreeMap<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            m.merge(k, 1, Integer::sum);
        }

        int max = 0;
        long ans = 0;

        for (Long l : m.keySet()) {
            int a = m.get(l);
            if (a > max) {
                max = a;
                ans = l;
            }
        }

        System.out.println(ans);
    }
}
