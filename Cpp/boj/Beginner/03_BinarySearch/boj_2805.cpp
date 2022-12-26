//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static long long solve(vector<long long>& v, int m) {
    long long left = 0;
    long long right = *max_element(v.begin(), v.end());
    long long ans = 0;

    while (left <= right) {
        long long mid = (left + right) / 2;
        long long tmp = 0;

        for (long long k : v)
            if (k > mid)
                tmp += k - mid;

        if (tmp < m) right = mid - 1;
        else {
            left = mid + 1;
            ans = max(ans, mid);
        }
    }

    return ans;
}

void boj_2805() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    vector<long long> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    cout << solve(v, m);
}