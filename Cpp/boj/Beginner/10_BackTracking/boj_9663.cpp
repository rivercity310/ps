//
// Created by seungsu on 12/24/22.
//

#include <bits/stdc++.h>
using namespace std;

static int N;
static int ans;
static int flag_a[16];
static int flag_b[16 * 2];
static int flag_c[16 * 2];

static void solve(int i) {
    for (int j = 0; j < N; j++) {
        if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + N - 1]) {
            if (i == N - 1) ans++;
            else {
                flag_a[j] = flag_b[i + j] = flag_c[i - j + N - 1] = 1;
                solve(i + 1);
                flag_a[j] = flag_b[i + j] = flag_c[i - j + N - 1] = 0;
            }
        }
    }
}

void boj_9663() {
    cin >> N;
    solve(0);
    cout << ans;
}