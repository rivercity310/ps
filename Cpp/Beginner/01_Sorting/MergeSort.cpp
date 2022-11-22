//
// Created by seungsu on 22. 11. 22.
//

#include <iostream>
#include <vector>
#include <random>

using namespace std;

constexpr int MAX = 10;

static void print_arr(vector<int>& arr) {
    for (int k : arr)
        cout << k << " ";
    cout << "\n";
}

static void merging(vector<int>& arr, int left, int mid, int right) {
    vector<int> tmp(MAX);

    int i = left;
    int j = mid + 1;
    int k = left;

    while (i <= mid && j <= right) {
        if (arr[i] < arr[j]) tmp[k++] = arr[i++];
        else tmp[k++] = arr[j++];
    }

    if (i <= mid) {
        for (int a = i; a <= mid; a++)
            tmp[k++] = arr[a];
    }

    else {
        for (int a = j; a <= right; a++)
            tmp[k++] = arr[a];
    }

    for (int a = left; a <= right; a++)
        arr[a] = tmp[a];
}

static void merge_sort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merging(arr, left, mid, right);
    }
}

void merge_sort_test() {
    random_device rd;
    mt19937 rand(rd());
    uniform_int_distribution<int> dist(1, 100);

    vector<int> v(MAX);
    for (int i = 0; i < MAX; i++)
        v[i] = dist(rand);

    cout << "[ 생성된 배열 ]" << "\n";
    print_arr(v);

    merge_sort(v, 0, v.size() - 1);

    cout << "[ 정렬된 배열 ]" << "\n";
    print_arr(v);
}