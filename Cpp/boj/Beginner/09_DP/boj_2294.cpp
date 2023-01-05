//
// Created by seungsu on 1/5/23.
//

#include <bits/stdc++.h>
using namespace std;
constexpr int INF = 100001;

static vector<int> coins;
static vector<int> dp(10001, INF);

void boj_2294() {
    int n, k;
    cin >> n >> k;
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        coins.push_back(x);

        for (int j = x; j <= k; j++) {
            dp[j] = min(dp[j], dp[j - x] + 1);
        }
    }

    if (dp[k] == INF) cout << -1;
    else cout << dp[k];
}