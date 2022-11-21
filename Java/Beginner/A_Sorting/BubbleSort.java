package Beginner.A_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {
    private static StringTokenizer st;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    private static void bubbleSort() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }

                else break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int idx = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        bubbleSort();

        System.out.println("[ 버블 정렬 완료 ]");
        for (int k : arr)
            System.out.print(k + " ");

        br.close();
    }
}
