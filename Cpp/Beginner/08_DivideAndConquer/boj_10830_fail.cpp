//
// Created by seungsu on 11/30/22.
//

// 재귀를 이용한 방법 -> 시간초과

#include <iostream>

using namespace std;

constexpr int MAX = 1001;

static unsigned long long mat[MAX][MAX];
static unsigned long long tmp_mat[MAX][MAX];
static unsigned long long ans[MAX][MAX];

static void solve(unsigned long long tmp[][MAX], int n, int times) {
    if (times == 0) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                cout << tmp[i][j] % 1000 << " ";
            cout << "\n";
        }
        return;
    }

    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            unsigned long long v = 0;

            for (int j = 0; j < n; j++) {
                v += tmp[k][j] * mat[j][i];
            }

            tmp_mat[k][i] = v;
        }
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            ans[i][j] = tmp_mat[i][j];

    solve(ans, n, times - 1);
}

void boj_10830() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, b;
    cin >> n >> b;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> mat[i][j];

    solve(mat, n, b - 1);
}

// 1 2  1 2    7 10  1 2    37 54
// 3 4  3 4   15 22  3 4    81 118