package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            if (binSearch(0, N - 1, B[i])) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean binSearch(int left, int right, int key) {
        if (left > right) return false;
        int mid = (left + right) / 2;

        if (A[mid] == key) return true;
        else if (A[mid] < key) return binSearch(mid + 1, right, key);
        else return binSearch(left, mid - 1, key);
    }
}
