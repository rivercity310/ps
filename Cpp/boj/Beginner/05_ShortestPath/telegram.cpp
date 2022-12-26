//
// Created by seungsu on 22. 11. 23.
//

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

static void solve(vector<vector<pair<int, int>>>& grp, int start) {
    priority_queue<pair<int, int>> pq;
    vector<int> distance(grp.size(), 1e9);

    pq.push(make_pair(0, start));
    distance[start] = 0;

    while (!pq.empty()) {
        pair<int, int> pr = pq.top();
        pq.pop();

        int dist = -pr.first;
        int now = pr.second;

        if (distance[now] < dist)
            continue;

        for (pair<int, int>& p : grp[now]) {
            int end_vtx = p.first;
            int weight = p.second;
            int cost = distance[now] + weight;

            if (distance[end_vtx] > cost) {
                distance[end_vtx] = cost;
                pq.push(make_pair(-cost, end_vtx));
            }
        }
    }

    int cnt = 0;
    int max_val = -1;

    for (int dist : distance) {
        if (dist != 1e9 && dist != 0) {
            cnt++;
            max_val = std::max(max_val, dist);
        }
    }

    cout << cnt << " " << max_val;
}

void telegram() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, m, c;
    cin >> n >> m >> c;

    vector<vector<pair<int, int>>> grp(n + 1);
    while (m--) {
        int x, y, z;
        cin >> x >> y >> z;

        grp[x].push_back(make_pair(y, z));
        grp[y].push_back(make_pair(x, z));
    }

    solve(grp, c);
}