//
// Created by seungsu on 22. 11. 25.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static void solve(vector<vector<int>>& grp) {
    queue<int> q;
    vector<bool> visited(grp.size(), false);
    vector<int> ans(grp.size());

    q.push(1);
    visited[1] = true;

    while (!q.empty()) {
        int parent = q.front();
        q.pop();

        // parent는 부모노드, child는 자식노드들..
        for (int child : grp[parent]) {
            if (!visited[child]) {
                ans[child] = parent;
                visited[child] = true;
                q.push(child);
            }
        }
    }

    for (int i = 2; i < ans.size(); i++)
        cout << ans[i] << "\n";
}

void boj_11725() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    vector<vector<int>> v(n + 1, vector<int>());

    for (int i = 0; i < n - 1; i++) {
        int a, b;
        cin >> a >> b;

        v[a].push_back(b);
        v[b].push_back(a);
    }

    solve(v);
}