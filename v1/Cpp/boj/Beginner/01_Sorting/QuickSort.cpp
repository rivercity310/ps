//
// Created by seungsu on 22. 11. 17.
//

#include <iostream>
#include <vector>

using namespace std;

static void quick_sort(vector<int>& v, int start, int end) {
    // 종료 조건 : 원소의 개수가 1개인 경우
    if (start >= end)
        return;

    int pivot = start;
    int left = start + 1;
    int right = end;

    while (left <= right) {
        while (v[pivot] >= v[left] && left <= end)
            left++;

        while (v[pivot] <= v[right] && right > start)
            right--;

        if (left > right)
            std::swap(v[pivot], v[right]);
        else
            std::swap(v[left], v[right]);
    }

    quick_sort(v, 0, right - 1);
    quick_sort(v, right + 1, end);
}

void quick_sort_test() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    quick_sort(v, 0, n - 1);

    cout << "[ 정렬 완료 ]" << "\n";
    for (int val : v)
        cout << val << " ";
}