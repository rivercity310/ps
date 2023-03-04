//
// Created by seungsu on 22. 11. 22.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

static int solve(vector<vector<int>>& grp, int start, int end) {
    priority_queue<pair<int, int>> pq;
    vector<int> distance(grp.size(), 1e9);

    pq.push(make_pair(0, start));
    distance[start] = 0;

    while (!pq.empty()) {
        pair<int, int> tmp = pq.top();
        pq.pop();

        int dist = -tmp.first;
        int now = tmp.second;

        if (distance[now] < dist)
            continue;

        for (int k : grp[now]) {
            if (k >= grp.size())
                continue;

            int weight = k == now * 2 ? 0 : 1;
            int cost = distance[now] + weight;

            if (distance[k] > cost) {
                distance[k] = cost;
                pq.push(make_pair(-cost, k));
            }
        }
    }

    return distance[end];
}

void boj_13549() {
    int n, k;
    cin >> n >> k;

    int m = std::max(n, k);
    vector<vector<int>> grp(2 * m);

    grp[0].push_back(1);
    grp[1].push_back(0);
    grp[1].push_back(2);

    for (int i = 2; i < grp.size(); i++) {
        grp[i].push_back(i - 1);
        grp[i].push_back(i + 1);
        grp[i].push_back(2 * i);
    }

    cout << solve(grp, n, k);
}