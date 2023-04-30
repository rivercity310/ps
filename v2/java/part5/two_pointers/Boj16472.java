package part5.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj16472 {
    static BufferedReader br;
    static String str;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        solve();
    }

    static void solve() {
        int max = 0;
        int kind = 0;

        int[] scan = new int[26];

        for (int right = 0, left = 0; right < str.length(); right++) {
            scan[str.charAt(right) - 'a']++;
            if (scan[str.charAt(right) - 'a'] == 1) kind++;

            while (kind > N) {
                scan[str.charAt(left) - 'a']--;
                if (scan[str.charAt(left) - 'a'] == 0) kind--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
