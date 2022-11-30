//
// Created by seungsu on 11/30/22.
//

#include <iostream>
#include <vector>

using namespace std;

// dp -> 메모리 초과.. (만약 범위가 조금 더 좁다면 dp를 이용해보자)

static vector<unsigned> dp;

static int solve(unsigned a, unsigned b, unsigned c) {
    if (b == 1) return a % c;
    if (dp[b] != 0) return dp[b];
    if (b & 1) return dp[b] = solve(a * a, b - 1, c);
    else return dp[b] = solve(a, b / 2, c) * solve(a, b / 2, c);
}

void boj_1629_fail() {
    int a, b, c;
    cin >> a >> b >> c;

    dp = vector<unsigned>(b + 1, 0);
    // (a^b)%c를 출력 -> 분할정복

    cout << solve(a, b, c) % c;
}