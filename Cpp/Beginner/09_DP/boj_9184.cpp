//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#define endl "\n"

using namespace std;
constexpr int MAX = 51;

static int dp[MAX][MAX][MAX];

static int solve(int a, int b, int c) {
    if (a <= 0 or b <= 0 or c <= 0) return 1;
    if (dp[a][b][c]) return dp[a][b][c];

    if (a > 20 or b > 20 or c > 20)
            return solve(20, 20, 20);

    if (a < b and b < c) {
        dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c);
        return dp[a][b][c];
    }

    dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1);
    return dp[a][b][c];
}

void boj_9184() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        int a, b, c;
        cin >> a >> b >> c;

        if (a == -1 && b == -1 && c == -1)
            break;

        cout << "w(" << a << ", " << b << ", " << c << ") = ";
        cout << solve(a, b, c);
        cout << endl;
    }
}