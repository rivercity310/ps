//
// Created by seungsu on 1/14/23.
//

#include <bits/stdc++.h>
using namespace std;

static int N, M;
static vector<vector<int>> space;
static vector<vector<bool>> visited;
static vector<int> x = { -1, 1, 0, 0 };
static vector<int> y = { 0, 0, -1, 1 };

static void solve(int i, int j) {
    if (visited[i][j]) return;
    if (space[i][j] == 1) return;

    visited[i][j] = true;

    for (int k = 0; k < 4; k++) {
        int dx = x[k] + i;
        int dy = y[k] + j;

        if (dx < 0) dx = N - 1;
        if (dx >= N) dx = 0;
        if (dy < 0) dy = M - 1;
        if (dy >= M) dy = 0;

        if (space[dx][dy] == 0) {
            space[dx][dy] = -1;
            solve(dx, dy);
        }
    }
}

void v2() {
    cin >> N >> M;
    space = vector<vector<int>>(N, vector<int>(M));
    visited = vector<vector<bool>>(N, vector<bool>(M));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            cin >> space[i][j];

    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (space[i][j] == 0) {
                solve(i, j);
                cnt++;
            }
        }
    }

    cout << cnt;
}