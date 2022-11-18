//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <algorithm>

using namespace std;

/*
손님이 요청한 길이가 M일 때, 적어도 M 만큼의 떡을 얻기 위한 절단기 높이의 최댓값
 */

static int cutter(int* arr, int n, int m) {
    int left = 0;
    int right = *max_element(arr, arr + n);
    int result = 0;

    while (left <= right) {
        int mid = (left + right) / 2;
        int tmp = 0;

        for (int i = 0; i < n; i++)
            if (arr[i] > mid)
                tmp += arr[i] - mid;

        if (tmp < m) right = mid - 1;
        else {
            result = mid;
            left = mid + 1;
        }
    }

    return result;
}

void cutting_rice_cake_test() {
    int n, m;
    cin >> n >> m;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    int result = cutter(arr, n, m);
    cout << result;

    delete[] arr;
}