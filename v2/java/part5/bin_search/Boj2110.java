package part5.bin_search;

import java.util.*;
import java.io.*;

public class Boj2110 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        System.out.println(solve());
    }

    static int solve() {
        int left = 1;
        int right = home[N - 1] - home[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int router = install(mid);
            if (C > router) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    static int install(int mid) {
        int router = 1;
        int last = home[0];

        for (int i = 1; i < N; i++) {
            if (home[i] >= last + mid) {
                router++;
                last = home[i];
            }
        }

        return router;
    }
}