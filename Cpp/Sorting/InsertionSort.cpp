//
// Created by seungsu on 22. 11. 17.
//

#include "InsertionSort.h"
#include <iostream>
#include <limits>          // INT_MIN 값 사용
#include <algorithm>       // std::max_element

using namespace std;

/* algorithm 헤더의 함수를 사용하여 간략하게 구현 가능 */
static void insertion_sort(int arr[], int n) {
    for (int i = n - 1; i > 1; i--) {
        int* max_elem = std::max_element(arr, arr + i + 1);
        std::swap(arr[i], *max_elem);
    }
}

void insertion_sort_test() {
    int n;
    cin >> n;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    insertion_sort(arr, n);

    cout << "[ 배열 정렬 완료 ]" << "\n";
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";

    delete[] arr;
}