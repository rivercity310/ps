package Beginner.C_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2110 {
    static StringTokenizer st;
    static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> arr;

    private static int install(int mid) {
        // 첫번째 집은 무조건 설치한다고 가정
        int router = 1;
        int last = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int loc = arr.get(i);

            if (loc >= last + mid) {
                router++;
                last = loc;
            }
        }

        return router;
    }

    private static int solve(int n, int c) {
        int left = 1;
        int right = arr.get(n - 1) - arr.get(0);
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int router = install(mid);

            if (router < c) right = mid - 1;
            else if (router > c) left = mid + 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }

        return ans;
    }

    /*
    [ lower bound 방식 (이상) ]
    데이터 내 특정 K 값보다 같거나 큰 값이 처음 나오는 위치를 리턴

    [ upper bound 방식 (초과) ]
    데이터 내 특정 K 값보다 처음으로 큰 값이 나오는 위치를 리턴

    이 문제는 "최대 거리"를 구해야하기 때문에 upper bound 방식으로 이분 탐색해야 한다.
    */
    static int solve2(int n, int c) {
        int left = 1;
        int right = arr.get(n - 1) - arr.get(0) + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (install(mid) < c) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);

        System.out.println(solve2(n, c));
    }
}
