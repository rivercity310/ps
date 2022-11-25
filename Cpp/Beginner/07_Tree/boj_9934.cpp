//
// Created by seungsu on 22. 11. 25.
//

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

static vector<vector<int>> ans;

static void solve(vector<int>& arr, int left, int right, int depth) {
    if (depth > (int)(log2(arr.size() + 1)))
        return;

    int mid = (left + right) / 2;
    ans[depth].push_back(arr[mid]);

    solve(arr, left, mid - 1, depth + 1);
    solve(arr, mid + 1, right, depth + 1);
}

void boj_9934() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int k;
    cin >> k;

    int size = pow(2, k) - 1;
    vector<int> arr(size);
    ans = vector<vector<int>>(k + 1);

    for (int i = 0; i < size; i++)
        cin >> arr[i];

    solve(arr, 0, size - 1, 1);

    for (int i = 1; i <= k; i++) {
        for (int val : ans[i])
            cout << val << " ";
        cout << "\n";
    }
}