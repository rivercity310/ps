package Beginner.B_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] mat;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            int col = 0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
                mat[i][col++] = Integer.parseInt(st.nextToken());
        }

        // 선택된 행에서 가장 작은 수 선택 -> 그 중에서 제일 큰 수 출력
        int max = 0;
        for (int i = 0; i < n; i++) {
            int min = Arrays.stream(mat[i]).min().getAsInt();
            max = max > min ? max : min;
        }

        System.out.println(max);
        br.close();
    }
}
