//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <algorithm>
#include <unordered_set>

using namespace std;

constexpr int None = -1;

static int binary_search_recursive(int* arr, int start, int end, int part) {
    if (start > end)
        return None;

    int mid = (start + end) / 2;

    if (arr[mid] == part)
        return mid;
    else if (arr[mid] > part)
        return binary_search_recursive(arr, start, mid - 1, part);
    else
        return binary_search_recursive(arr, mid + 1, end, part);
}

// 이진 탐색을 이용한 풀이
void find_part_test1() {
    int n;
    cin >> n;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    std::sort(arr, arr + n);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int part;
        cin >> part;

        int result = binary_search_recursive(arr, 0, n - 1, part);

        if (result == None) cout << "no" << "\n";
        else cout << "yes" << "\n";
    }

    delete[] arr;
}

// unordered_set 자료 구조를 이용한 풀이
void find_part_test2() {
    int n;
    cin >> n;

    unordered_set<int> s;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        s.insert(x);
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int part;
        cin >> part;

        // 찾지 못한 경우 end() 반환
        if (s.find(part) == s.end()) cout << "no" << "\n";
        else cout << "yes" << "\n";
    }
}