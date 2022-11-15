package Beginner.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
10명의 점수를 배열에 입력받고, 선택정렬을 통해 배열을 정렬한 뒤 순차적으로 학점을 부여한다.
학점 : F, D, D+, C, C+, B, B+, A, A+(2명)
 */

public class SelectionSort {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int n = 10;
    private static int idx = 0;
    private static final int[] arr = new int[n];

    /*
    [ 선택 정렬 ]
    아직 정렬되지 않은 부분에서 가장 큰 수와 맨 뒷 수를 교환(Swap)한다.
    */
    private static void selection_sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            int max = Integer.MIN_VALUE;
            int max_index = -1;           /* 가장 큰 수의 인덱스를 저장하는 변수 */

            for (int j = 0; j <= i; j++) {
                if (arr[j] > max) {
                    max_index = j;
                    max = arr[j];
                }
            }

            int tmp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = tmp;
        }
    }

    /* 선택정렬을 응용한 Solution */
    private static void solution() {
        String[] ans = new String[arr.length];
        boolean[] visited = new boolean[arr.length];
        String[] grades = {"A+", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};      // 방문처리 배열

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int max_index = -1;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max && !visited[j]) {
                    max = arr[j];
                    max_index = j;
                }
            }

            ans[max_index] = grades[cnt++];
            visited[max_index] = true;
        }

        System.out.println("[결과를 출력합니다]");
        for (String val : ans)
            System.out.print(val + " ");
    }

    public static void main(String[] args) throws IOException {
        var st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        // selection_sort();

        solution();

        System.out.println("\n[정렬된 배열 출력]");
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }
}
