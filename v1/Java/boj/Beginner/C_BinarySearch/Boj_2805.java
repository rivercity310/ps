package boj.Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2805 {
    static StringTokenizer st;
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static List<Long> arr;

    private static long solve(int m) {
        long left = 0;
        long right = Collections.max(arr);
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;

            for (long a : arr)
                if (a > mid)
                    tmp += a - mid;

            if (tmp < m) right = mid - 1;
            else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr.add(Long.parseLong(st.nextToken()));

        System.out.println(solve(m));
    }
}
