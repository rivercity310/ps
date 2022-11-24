//
// Created by seungsu on 22. 11. 24.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
constexpr int INF = 1e9;

static int solve(vector<vector<int>>& grp) {
    for (int k = 1; k < grp.size(); k++)
        for (int i = 1; i < grp.size(); i++)
            for (int j = 1; j < grp.size(); j++)
                grp[i][j] = min(grp[i][j], grp[i][k] + grp[k][j]);

    int ans = INF;

    for (int i = 1; i < grp.size(); i++) {
        for (int j = 1; j < grp.size(); j++) {
            if (i == j) continue;
            ans = min(grp[i][j] + grp[j][i], ans);
        }
    }

    return ans == INF ? -1 : ans;
}

void boj_1956() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int v, e;
    cin >> v >> e;

    vector<vector<int>> grp(v + 1, vector<int>(v + 1, INF));
    while (e--) {
        int a, b, c;
        cin >> a >> b >> c;
        grp[a][b] = c;
    }

    cout << solve(grp);
}