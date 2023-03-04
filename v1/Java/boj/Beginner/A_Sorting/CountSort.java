package boj.Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountSort {
    private static StringTokenizer st;
    private static final StringBuilder sb =
            new StringBuilder();
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static int[] arr;

    private static int[] count_sort() {
        int max_element = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max_element + 1];

        for (int val : arr)
            count[val]++;

        return count;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int idx = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        int[] rst = count_sort();
        for (int i = 0; i < rst.length; i++)
            for (int j = 0; j < rst[i]; j++)
                sb.append(i).append(" ");

        System.out.println(sb);
    }
}
