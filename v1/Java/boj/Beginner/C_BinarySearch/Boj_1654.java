package boj.Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1654 {
    static StringTokenizer st;
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static List<Long> arr;

    static long solve(int n) {
        long left = 1;
        long right = Collections.max(arr);
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;

            for (long val : arr)
                tmp += val / mid;

            if (tmp < n) right = mid - 1;
            else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i < k; i++)
            arr.add(Long.parseLong(br.readLine()));

        System.out.println(solve(n));
        br.close();
    }
}
