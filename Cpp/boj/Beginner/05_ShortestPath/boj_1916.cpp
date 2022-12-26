//
// Created by seungsu on 22. 11. 21.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static int dijkstra(vector<vector<pair<int, int>>>& grp, int start, int end) {
    priority_queue<pair<int, int>> pq;
    int distance[grp.size()];
    fill(distance, distance + grp.size(), 1e9);

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
            int end_vertex = p.first;
            int weight = p.second;
            int cost = distance[now] + weight;

            if (distance[end_vertex] > cost) {
                distance[end_vertex] = cost;
                pq.push(make_pair(-cost, end_vertex));
            }
        }
    }

    return distance[end];
}

void boj_1916() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<pair<int, int>>> grp(n + 1);
    while (m--) {
        int u, v, w;
        cin >> u >> v >> w;

        grp[u].push_back(make_pair(v, w));
    }

    int start, end;
    cin >> start >> end;

    cout << dijkstra(grp, start, end);
}