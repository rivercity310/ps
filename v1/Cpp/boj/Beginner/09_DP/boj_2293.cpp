//
// Created by seungsu on 1/5/23.
//

#include <bits/stdc++.h>
using namespace std;

static vector<int> coins;
static int dp[10001];

void boj_2293() {
    int n, k;
    cin >> n >> k;

    dp[0] = 1;

    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        coins.push_back(x);

        for (int j = x; j <= k; j++)
            dp[j] += dp[j - x];
    }

    cout << dp[k];
}