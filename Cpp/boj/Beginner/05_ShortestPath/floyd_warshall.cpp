//
// Created by seungsu on 22. 11. 23.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

constexpr int MAX = 1e9;

static void solve(vector<vector<int>>& grp) {
    int size = grp.size();

    for (int k = 1; k < size; k++)
        for (int a = 1; a < size; a++)
            for (int b = 1; b < size; b++)
                grp[a][b] = min(grp[a][b], grp[a][k] + grp[k][b]);

    for (int a = 1; a < size; a++) {
        for (int b = 1; b < size; b++) {
            if (grp[a][b] == MAX) cout << -1 << " ";
            else cout << grp[a][b] << " ";
        }
        cout << "\n";
    }
}

void floyd_warshall() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> grp(n + 1, vector<int>(n + 1, MAX));
    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++)
            if (i == j) grp[i][j] = 0;

    while (m--) {
        int x, y, z;
        cin >> x >> y >> z;
        grp[x][y] = z;
    }

    solve(grp);
}