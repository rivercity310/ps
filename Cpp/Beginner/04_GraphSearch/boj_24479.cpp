//
// Created by seungsu on 22. 11. 24.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static int cnt = 0;

static void solve(vector<vector<int>>& grp, vector<int>& visited, vector<int>& ans, int r) {
    visited[r] = 1;
    ans[r] = ++cnt;

    for (int k : grp[r])
        if (!visited[k])
            solve(grp, visited, ans, k);
}

void boj_24479() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, m, r;
    cin >> n >> m >> r;

    vector<vector<int>> grp(n + 1, vector<int>());

    while (m--) {
        int u, v;
        cin >> u >> v;

        grp[u].push_back(v);
        grp[v].push_back(u);
    }

    for (vector<int>& v : grp)
        std::sort(v.begin(), v.end());

    vector<int> visited(grp.size(), 0);
    vector<int> ans(grp.size(), 0);

    solve(grp, visited, ans, r);

    for (int i = 1; i < ans.size(); i++)
        cout << ans[i] << "\n";
}