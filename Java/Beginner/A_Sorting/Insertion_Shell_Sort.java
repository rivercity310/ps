package Beginner.A_Sorting;

import java.util.Random;

public class Insertion_Shell_Sort {
    static final int[] arr = new int[30];
    static final Random rd = new Random();

    private static void print_arr() {
        for (int k : arr)
            System.out.print(k + " ");
        System.out.println();
    }

    private static void insertion_sort() {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            for (; j > 0 && arr[j - 1] > tmp; j--)
                arr[j] = arr[j - 1];
            arr[j] = tmp;
        }
    }

    private static void shell_sort() {
        int n = arr.length;
        int h = 1;

        for (; h < n / 9; h = h * 3 + 1);

        while (h > 0) {
            for (int i = h; i < n; i++) {
                int tmp = arr[i];
                int j = i - h;

                for (; j >= 0 && arr[j] > tmp; j -= h)
                    arr[j + h] = arr[j];
                arr[j + h] = tmp;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = rd.nextInt(100) + 1;

        System.out.println("[ 생성된 배열 ]");
        print_arr();

        shell_sort();

        System.out.println("[ 정렬된 배열 ]");
        print_arr();}
}
