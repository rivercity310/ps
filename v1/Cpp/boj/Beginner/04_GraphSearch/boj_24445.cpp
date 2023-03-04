//
// Created by seungsu on 22. 11. 23.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

void bfs(vector<vector<int>>& grp, int start) {
    queue<int> q;
    vector<bool> visited(grp.size(), false);

    q.push(start);
    visited[start] = true;

    vector<int> rst(grp.size(), 0);
    int cnt = 1;

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        rst[now] = cnt++;

        for (int k : grp[now]) {
            if (!visited[k]) {
                q.push(k);
                visited[k] = true;
            }
        }
    }

    for (int i = 1; i < rst.size(); i++)
        cout << rst[i] << "\n";
}

void boj_24445() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, r;
    cin >> n >> m >> r;

    vector<vector<int>> grp(n + 1, vector<int>());
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        grp[a].push_back(b);
        grp[b].push_back(a);
    }

    for (int i = 0; i < grp.size(); i++) {
        sort(grp[i].begin(), grp[i].end(), [](int a, int b) {
            return a > b;
        });
    }

    bfs(grp, r);
}