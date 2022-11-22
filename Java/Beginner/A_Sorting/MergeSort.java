package Beginner.A_Sorting;

import java.util.Random;

public class MergeSort {
    static int[] arr;
    static final int MAX = 10;
    static final Random rd = new Random();

    private static void print_arr() {
        for (int i = 0; i < MAX; i++)
            System.out.printf("%-5d", arr[i]);
        System.out.println();
    }

    private static void merging(int left, int mid, int right) {
        int[] tmp = new int[MAX];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        if (i > mid) {
            for (int a = j; a <= right; a++)
                tmp[k++] = arr[a++];
        }

        else {
            for (int a = i; a <= mid; a++)
                tmp[k++] = arr[a];
        }

        for (int a = left; a <= right; a++)
            arr[a] = tmp[a];
    }

    private static void merge_sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merging(left, mid, right);
        }
    }

    public static void main(String[] args) {
        arr = new int[MAX];
        for (int i = 0; i < MAX; i++)
            arr[i] = rd.nextInt(100) + 1;

        System.out.println("[ 생성된 배열 ]");
        print_arr();

        merge_sort(0, MAX - 1);

        System.out.println("[ 정렬된 배열 ]");
        print_arr();
    }
}
