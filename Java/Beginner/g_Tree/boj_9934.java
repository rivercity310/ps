package Beginner.g_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_9934 {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;
    private static List<Integer> arr;
    private static StringBuilder stringbuilders[];

    private static void solve(int left, int right, int depth, int k) {
        if (depth > k)
            return;

        int mid = (left + right) / 2;
        stringbuilders[depth].append(arr.get(mid)).append(" ");

        solve(left, mid - 1, depth + 1, k);
        solve(mid + 1, right, depth + 1, k);
    }

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, k) - 1;

        arr = new ArrayList<>(size);
        st = new StringTokenizer(br.readLine());
        stringbuilders = new StringBuilder[k + 1];
        Arrays.setAll(stringbuilders, elem -> new StringBuilder());

        for (int i = 0; i < size; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        solve(0, size - 1, 1, k);

        for (int i = 1; i <= k; i++)
            System.out.println(stringbuilders[i]);
    }
}
