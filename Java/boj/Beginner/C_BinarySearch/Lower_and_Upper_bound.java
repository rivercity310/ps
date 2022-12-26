package boj.Beginner.C_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lower_and_Upper_bound {
    static List<Integer> arr;

    private static int lower_bound(int key) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) >= key) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private static int upper_bound(int key) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) > key) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private static int binary_search(int key) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr.get(mid) > key) right = mid - 1;
            else if (arr.get(mid) < key) left = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        arr = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 15, 15, 15, 17, 19));
        int key = 15;

        System.out.println(lower_bound(key));
        System.out.println(upper_bound(key));
        System.out.println(binary_search(key));     // key와 동일한 원소가 중복되어 있을 때 만족하는 인덱스 아무거나 찾아준다..
    }
}
