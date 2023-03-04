#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long ull;

static int N;
static vector<ull> dp;
static vector<ull> tmp;

static void getNum(int n) {
    for (int i = 2; i <= n; i++)
        for (int j = 1; i * j <= n; j++)
            tmp[i * j] += i;
}

static ull solve(int n) {
    if (n == 1) return 1;
    if (n == 2) return 4;
    if (dp[n]) return dp[n];
    return dp[n] = solve(n - 1) + tmp[n];
}

void ex1() {
    cin >> N;
    dp.resize(N + 1);
    tmp = vector<ull>(N + 1, 1);
    getNum(N);

    cout << solve(N);
}

