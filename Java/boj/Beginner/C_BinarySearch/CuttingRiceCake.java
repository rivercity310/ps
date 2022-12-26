package boj.Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CuttingRiceCake {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> arr;

    private static int cutter(int m) {
        int left = 0;
        int right = Collections.max(arr);
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = 0;

            for (Integer t : arr)
                if (t > mid)
                    tmp += t - mid;

            if (tmp < m) right = mid - 1;
            else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        int result = cutter(m);
        System.out.println(result);
    }
}
