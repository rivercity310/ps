package part5.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15970 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static Map<Integer, List<Integer>> dots;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dots = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dots.computeIfAbsent(c, k -> new ArrayList<>());
            dots.get(c).add(x);
        }

        int ans = 0;

        for (int color : dots.keySet()) {
            List<Integer> lst = dots.get(color);
            lst.sort((a, b) -> a - b);

            for (int i = 0; i < lst.size(); i++) {
                int now = lst.get(i);

                if (i == 0) ans += lst.get(i + 1) - now;
                else if (i == lst.size() - 1) ans += now - lst.get(i - 1);
                else ans += Math.min(now - lst.get(i - 1), lst.get(i + 1) - now);
            }
        }

        System.out.println(ans);
    }
}
