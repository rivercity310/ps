//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#include <vector>

using namespace std;
constexpr int INF = 1e8;

vector<vector<int>> Mat;

static void solve(int size) {
    for (int k = 1; k <= size; k++)
        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= size; j++)
                Mat[i][j] = min(Mat[i][j], Mat[i][k] + Mat[k][j]);
}

void boj_1504() {
    int n, e;
    cin >> n >> e;

    Mat = vector<vector<int>>(n + 1, vector<int>(n + 1, INF));

    for (int i = 0; i < e; i++) {
        int a, b, c;
        cin >> a >> b >> c;

        Mat[a][b] = c;
        Mat[b][a] = c;
    }

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            if (i == j) Mat[i][j] = 0;

    int v1, v2;
    cin >> v1 >> v2;

    solve(n);

    int tmp1 = Mat[1][v1] + Mat[v1][v2] + Mat[v2][n];
    int tmp2 = Mat[1][v2] + Mat[v2][v1] + Mat[v1][n];

    if (tmp1 >= INF && tmp2 >= INF) cout << -1;
    else cout << min(tmp1, tmp2);
}