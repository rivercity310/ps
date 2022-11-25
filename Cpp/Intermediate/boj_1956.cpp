//
// Created by seungsu on 22. 11. 25.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
constexpr int INF = 1e9;

static int solve(vector<vector<int>>& grp) {
    int size = grp.size();

    for (int k = 1; k < size; k++)
        for (int a = 1; a < size; a++)
            for (int b = 1; b < size; b++)
                grp[a][b] = min(grp[a][b], grp[a][k] + grp[k][b]);

    int ans = INF;

    for (int a = 1; a < size; a++) {
        for (int b = 1; b < size; b++) {
            if (a == b) continue;
            ans = min(ans, grp[a][b] + grp[b][a]);
        }
    }

    return ans == INF ? -1 : ans;
}

void boj_1956() {
    int V, E;
    cin >> V >> E;

    vector<vector<int>> grp(V + 1, vector<int>(V + 1, INF));

    while (E--) {
        int a, b, c;
        cin >> a >> b >> c;

        grp[a][b] = c;
    }

    cout << solve(grp);
}