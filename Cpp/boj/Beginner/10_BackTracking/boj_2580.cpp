//
// Created by seungsu on 12/25/22.
//

#include <bits/stdc++.h>
using namespace std;
constexpr int MAX = 9;

static int sudoku[MAX][MAX];
static vector<pair<int, int>> v;

static bool chk(int row, int col, int i) {
    for (int k = 0; k < MAX; k++)
        if (sudoku[row][k] == i || sudoku[k][col] == i) return false;

    int vx = (col / 3) * 3;
    int vy = (row / 3) * 3;

    for (int k = vy; k < vy + 3; k++)
        for (int j = vx; j < vx + 3; j++)
            if (sudoku[k][j] == i)
                return false;

    return true;
}

static bool dfs(int cur) {
    if (cur == v.size()) return true;

    int row = v[cur].first;
    int col = v[cur].second;

    for (int i = 1; i <= MAX; i++) {
        if (chk(row, col, i)) {
            sudoku[row][col] = i;
            if (dfs(cur + 1)) return true;
            sudoku[row][col] = 0;
        }
    }

    return false;
}

void boj_2580() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            int x;
            cin >> x;

            if (x == 0) v.push_back(make_pair(i, j));
            sudoku[i][j] = x;
        }
    }

    dfs(0);

    for (auto& a : sudoku) {
        for (auto& b : a) cout << b << ' ';
        cout << '\n';
    }
}