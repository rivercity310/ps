//
// Created by seungsu on 11/30/22.
//

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<unsigned, unsigned> dp;

static int solve(unsigned a, unsigned b, unsigned c) {
    if (b == 1) return a % c;
    if (dp[b]) return dp[b];
    if (b & 1) return dp[b] = a * solve(a, b / 2, c) * solve(a, b / 2, c) % c;
    else return dp[b] = solve(a, b / 2, c) * solve(a, b / 2, c) % c;
}

void boj_1629_with_dp() {
    int a, b, c;
    cin >> a >> b >> c;

    cout << solve(a, b, c) % c;
}