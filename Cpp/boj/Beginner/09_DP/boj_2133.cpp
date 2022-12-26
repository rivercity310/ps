//
// Created by seungsu on 12/27/22.
//

#include <iostream>
using namespace std;

static int d[31];

static int dp(int x) {
    if (x == 0) return 1;
    if (x == 1) return 0;
    if (x == 2) return 3;
    if (d[x]) return d[x];

    int rst = 3 * dp(x - 2);
    for (int i = 4; i <= x; i++)
        if (i % 2 == 0) rst += 2 * dp(x - i);

    return d[x] = rst;
}

void boj_2133() {
    int n;
    cin >> n;
    cout << dp(n);
}