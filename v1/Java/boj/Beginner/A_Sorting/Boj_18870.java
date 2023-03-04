package boj.Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_18870 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] w = new int[n];

        for (int i = 0; i < n; i++)
            w[i] = Integer.parseInt(st.nextToken());

        // int[] tmp = arr.clone();      // java deep copy

        // 중복 제거, 정렬 후 반환 (원본 배열 변화 X)
        int[] arr = Arrays.stream(w)
                .sorted()
                .distinct()
                .toArray();

        for (int k : w)
            sb.append(Arrays.binarySearch(arr, k)).append(" ");

        System.out.println(sb);
    }
}
