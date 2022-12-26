//
// Created by seungsu on 12/27/22.
//

#include <iostream>
using namespace std;
constexpr long long DIV = 1000000007;

static long long d[1000001][2];

static long long dp(int x) {
    d[0][0] = 0;
    d[1][0] = 2;
    d[2][0] = 7;
    d[2][1] = 1;

    for (int i = 3; i <= x; i++) {
        d[i][1] = (d[i - 1][1] + d[i - 3][0]) % DIV;
        d[i][0] = (d[i - 2][0] * 3 + d[i - 1][0] * 2 + d[i][1] * 2) % DIV;
    }

    return d[x][0];
}

void boj_14852() {
    int n;
    cin >> n;
    cout << dp(n);
}