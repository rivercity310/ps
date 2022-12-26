//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <algorithm>

constexpr int None = -1;

using namespace std;

static int binary_search(int* arr, int start, int end, int target) {
    while (start <= end) {
        int mid = (start + end) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            end = mid - 1;
        else
            start = mid + 1;
    }

    return None;
}

static int binary_search_recursive(int* arr, int start, int end, int target) {
    if (start > end)
        return None;

    int mid = (start + end) / 2;

    if (arr[mid] == target)
        return mid;
    else if (arr[mid] > target)
        return binary_search_recursive(arr, start, mid - 1, target);
    else
        return binary_search_recursive(arr, mid + 1, end, target);
}

void bin_search_test() {
    int n, target;
    cin >> n >> target;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    std::sort(arr, arr + n);

    // int result = binary_search(arr, 0, n - 1, target);
    int result = binary_search_recursive(arr, 0, n - 1, target);

    if (result == None)
        cout << "존재하지 않음";
    else
        cout << target << " : Index " << result << "에 존재";

    delete[] arr;
}