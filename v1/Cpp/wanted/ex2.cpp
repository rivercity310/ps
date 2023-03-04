//
// Created by seungsu on 1/13/23.
//

#include <bits/stdc++.h>
using namespace std;

typedef vector<vector<int>> Matrix;

static Matrix mat;
static int M, N;

static void solve() {
    int cnt = 0;

    for (int i = 0; i < M - 1; i++) {
        for (int j = i + 1; j < M; j++) {
            vector<int> space1 = mat[i];
            vector<int> space2 = mat[j];

            bool flag = true;
            for (int a = 0; a < N - 1; a++) {
                for (int b = a + 1; b < N; b++) {
                    if (space1[a] > space1[b])
                        if (space2[a] <= space2[b]) {
                            flag = false;
                            break;
                        }

                    if (space1[a] < space1[b])
                        if (space2[a] >= space2[b]) {
                            flag = false;
                            break;
                        }

                    if (space1[a] == space1[b])
                        if (space2[a] != space2[b]) {
                            flag = false;
                            break;
                        }
                }
            }

            if (flag) cnt++;
        }
    }

    cout << cnt;
}

void ex2() {
    cin >> M >> N;
    mat = vector<vector<int>>(M, vector<int>(N));

    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            cin >> mat[i][j];

    solve();
}