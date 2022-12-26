//
// Created by seungsu on 22. 11. 22.
//

#include <iostream>
#include <random>
#include <vector>

using namespace std;

static void print_vt(vector<int>& arr) {
    for (int k : arr)
        cout << k << " ";
    cout << "\n";
}

static void insertion_sort(vector<int>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        int tmp = arr[i];
        int j = i;

        for (; j > 0 && arr[j - 1] > tmp; j--)
            arr[j] = arr[j - 1];
        arr[j] = tmp;
    }
}

static void shell_sort(vector<int>& arr) {
    int n = arr.size();
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

void insertion_shell_sort_test() {
    random_device rd;
    mt19937 rand(rd());
    uniform_int_distribution<int> dist(1, 100); // 1 ~ 100까지의 균등분포

    vector<int> arr;
    for (int i = 0; i < 100; i++)
        arr.push_back(dist(rand));

    cout << "[ 생성된 배열 ]" << "\n";
    print_vt(arr);

    insertion_sort(arr);

    cout << "[ 정렬된 배열 ]" << "\n";
    print_vt(arr);
}