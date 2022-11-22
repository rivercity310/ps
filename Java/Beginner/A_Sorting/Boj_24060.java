package Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_24060 {
    static StringTokenizer st;
    static int[] arr;
    static int ans = -1;
    static int cnt = 0;
    static int n, k;

    private static void merging(int left, int mid, int right) {
        int[] tmp = new int[right + 2];

        int i = left;
        int j = mid + 1;
        int t = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }

        while (i <= mid)
            tmp[t++] = arr[i++];

        while (j <= right)
            tmp[t++] = arr[j++];

        for (int a = left; a <= right; a++) {
            if (++cnt == k) {
                ans = tmp[a];
                break;
            }
        }
    }

    private static void merge_sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merging(left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        merge_sort(0, n - 1);

        System.out.println(ans);
        br.close();
    }
}
