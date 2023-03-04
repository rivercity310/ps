//
// Created by seungsu on 1/14/23.
//
#include <bits/stdc++.h>
using namespace std;

static int N, MAX;
static vector<int> v;
static vector<int> dp;

static void solve() {
    dp[0] = 1;
    int cnt = 1;

    for (int i = 1; i < N; i++) {
        if (v[i - 1] == v[i]) {
    }
}

void v1() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N;
    v.resize(N);
    dp.resize(N + 1);

    // 왼쪽 1, 오른쪽 2
    for (int i = 0; i < N; i++) cin >> v[i];

    if (N == 1) cout << 1;
    else {
        solve();
        cout << MAX;
    }
}