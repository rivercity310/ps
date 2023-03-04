package boj.Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinSearch {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static final int None = -1;

    private static int binary_search(int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return None;
    }

    private static int binary_search_recursive(int left, int right, int target) {
        if (left > right)
            return None;

        int mid = (left + right) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return binary_search_recursive(left, mid - 1, target);
        else
            return binary_search_recursive(mid + 1, right, target);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int result = binary_search_recursive(0, n - 1, target);
        if (result == None) System.out.println("찾을 수 없음");
        else System.out.printf("%d : Index %d에 위치\n", target, result);
    }
}
