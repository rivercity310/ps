//
// Created by seungsu on 11/28/22.
//

#include <iostream>
#include <vector>

using namespace std;

static bool check_arr(vector<vector<int>>& v, int row, int col, int size) {
    for (int i = row; i < row + size; i++) {
        int val = v[row][col];

        for (int j = col; j < col + size; j++)
            if (v[i][j] != val)
                return false;
    }

    return true;
}

static void solve(vector<vector<int>>& v, int row, int col, int size) {
    if (check_arr(v, row, col, size)) {
        cout << v[row][col];
        return;
    }

    size /= 2;

    cout << "(";
    solve(v, row, col, size); // 왼쪽 위
    solve(v, row, col + size, size); // 오른쪽 위
    solve(v, row + size, col, size);      // 왼쪽 아래
    solve(v, row + size, col + size, size);    // 오른쪽 아래
    cout << ")";
}

void boj_1992() {
    int n;
    cin >> n;

    vector<vector<int>> v(n, vector<int>(n));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%1d", &v[i][j]);

    solve(v, 0, 0, n);
}