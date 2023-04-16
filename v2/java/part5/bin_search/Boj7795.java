package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7795 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;
    static int[] A, B;
    static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) B[i] = Integer.parseInt(st.nextToken());

            int ans = 0;
            Arrays.sort(B);

            for (int k : A) ans += lowerBound(k);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static int lowerBound(int k) {
        int left = 1;
        int right = M;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (B[mid] >= k) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }

        return ans;
    }
}