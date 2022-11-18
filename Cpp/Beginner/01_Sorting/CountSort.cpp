//
// Created by seungsu on 22. 11. 17.
//

// 계수 정렬 : O(N + K), K : 데이터의 최댓값

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static vector<int> count_sort(vector<int>& v) {
    int max_elem = *std::max_element(v.begin(), v.end());
    vector<int> count(max_elem + 1, 0);

    for (int val : v)
        count[val]++;

    return count;
}

void count_sort_test() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    auto rst = count_sort(v);
    for (int i = 0; i < rst.size(); i++)
        for (int j = 0; j < rst[i]; j++)
            cout << i << " ";
}


