//
// Created by seungsu on 1/13/23.
//
#include <bits/stdc++.h>
using namespace std;

static int N;
static vector<int> dp;

static int solve(int n) {
    if (n == 1) return 2;
    if (n == 2) return 6;
    if (dp[n]) return dp[n];
    return dp[n] = solve(n - 2) * 4;
}

void ex3() {
    cin >> N;
    dp.resize(N + 1);
    cout << solve(N);
}