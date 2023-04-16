package part5.bin_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1764 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;
    static int N, M;
    static String[] A, B;
    static List<String> ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new String[N];
        B = new String[M];
        ans = new ArrayList<>();

        for (int i = 0; i < N; i++) A[i] = br.readLine();
        for (int i = 0; i < M; i++) B[i] = br.readLine();

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++)
            if (binSearch(0, M - 1, A[i]))
                ans.add(A[i]);

        sb.append(ans.size()).append('\n');
        for (String str : ans)
            sb.append(str).append('\n');

        System.out.print(sb);
    }

    static boolean binSearch(int left, int right, String key) {
        if (left > right) return false;

        int mid = (left + right) / 2;
        int comp = B[mid].compareTo(key);

        if (comp == 0) return true;
        else if (comp < 0) return binSearch(mid + 1, right, key);
        else return binSearch(left, mid - 1, key);
    }
}
