package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3273 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, X, ans;
    static int[] A;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        X = Integer.parseInt(br.readLine());

        Arrays.sort(A);
        solve(X);

        System.out.println(ans);
    }

    static void solve(int x) {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = A[left] + A[right];
            if (sum >= x) {
                if (sum == x) ans++;
                right--;
            }
            else left++;
        }
    }
}
