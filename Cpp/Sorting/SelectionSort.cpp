//
// Created by seungsu on 22. 11. 17.
//

#include "SelectionSort.h"
#include <iostream>
#include <limits>          // INT_MIN 값 사용
#include <algorithm>       // std::max_element
#include <vector>

using namespace std;

/* algorithm 헤더의 함수를 사용하여 간략하게 구현 가능 */
static void selection_sort(int arr[], int n) {
    for (int i = n - 1; i > 1; i--) {
        int* max_elem = std::max_element(arr, arr + i + 1);
        std::swap(arr[i], *max_elem);
    }
}

/* 방문처리 배열을 응용한 선택정렬 */
static vector<string> selection_sort_app(vector<int>& arr, int n) {
    vector<string> grades = {"A+", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
    vector<string> ans(n);
    vector<bool> visited(n, false);
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        int max_elem = std::numeric_limits<int>::min();
        int max_index = std::numeric_limits<int>::min();

        for (int j = 0; j < n; j++) {
            if (arr[j] > max_elem && !visited[j]) {
                max_elem = arr[j];
                max_index = j;
            }
        }

        visited[max_index] = true;      // 방문처리
        ans[max_index] = grades[cnt++];
    }

    return ans;
}

void selection_sort_test() {
    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    auto ans = selection_sort_app(arr, n);

    cout << "[ 배열 정렬 완료 ]" << "\n";
    for (string str : ans)
        cout << str << " ";
}