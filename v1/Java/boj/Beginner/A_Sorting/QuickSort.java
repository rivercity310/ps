package boj.Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int idx = 0;

    private static void quick_sort(int[] arr, int start, int end) {
        if (start >= end) return;       // 종료 조건: 원소의 개수가 1

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // left: pivot보다 큰 값 찾기
            while (left <= end && arr[left] <= arr[pivot])
                left++;

            // right: pivot보다 작은 값 찾기
            while (right > start && arr[right] >= arr[pivot])
                right--;

            int tmp = arr[right];
            if (left > right) {                         // 만약 엇갈렸다면 작은 데이터(right)와 피벗 교환
                arr[right] = arr[pivot];
                arr[pivot] = tmp;
            }
            else {                                      // 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }

        // 분할 이후 왼쪽 부분, 오른쪽 부분에서 각각 다시 정렬을 수행 => arr[right]에는 피봇값
        quick_sort(arr, start, right - 1);
        quick_sort(arr, right + 1, end);
    }

    public static void main(String[] args) throws IOException {
        arr = new int[10];
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        quick_sort(arr, 0, arr.length - 1);

        System.out.println("[ 퀵정렬 수행 결과 ]");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
