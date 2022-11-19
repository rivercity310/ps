//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static long long solve(vector<long long>& arr, int n) {
    long long left = 1;
    long long right = *max_element(arr.begin(), arr.end());
    long long ans = 0;

    while (left <= right) {
        long long mid = (left + right) / 2;
        long long tmp = 0;

        for (long long v : arr)
            tmp += v / mid;

        if (tmp < n) right = mid - 1;
        else {
            left = mid + 1;
            ans = max(ans, mid);
        }
    }

    return ans;
}

void boj_1654() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int k, n;
    cin >> k >> n;

    vector<long long> arr(k);
    for (int i = 0; i < k; i++)
        cin >> arr[i];

    cout << solve(arr, n);
}