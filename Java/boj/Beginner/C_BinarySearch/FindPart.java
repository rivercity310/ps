package boj.Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindPart {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> arr;
    private static final int None = -1;

    private static int binary_search(int start, int end, int target) {
        if (start > end) return None;

        int mid = (start + end) / 2;

        if (arr.get(mid) == target)
            return mid;
        else if (arr.get(mid) > target)
            return binary_search(start, mid - 1, target);
        else
            return binary_search(mid + 1, end, target);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            arr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int result = binary_search(0, n - 1, x);

            if (result == None) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
