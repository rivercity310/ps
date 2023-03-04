//
// Created by seungsu on 12/27/22.
//

#include <bits/stdc++.h>
using namespace std;
constexpr int MAX = 1001;

static int d[MAX];

static int dp(int x) {
    if (x == 1) return 1;
    if (x == 2) return 3;
    if (d[x]) return d[x];
    return d[x] = (dp(x - 1) + (2 * dp(x - 2))) % 10007;
}

void boj_11726() {
    int n;
    cin >> n;
    cout << dp(n);
}