//
// Created by seungsu on 22. 11. 21.
//
#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

constexpr int INF = 1e9;

static vector<int> dijkstra(vector<vector<pair<int, int>>>& grp, int start) {
    priority_queue<pair<int, int>> pq;
    vector<int> distance(grp.size(), INF);

    pq.push({ 0, start });
    distance[start] = 0;

    while (!pq.empty()) {
        pair<int, int> p = pq.top();
        pq.pop();

        int dist = -p.first;
        int now = p.second;

        if (distance[now] < dist)
            continue;

        for (pair<int, int>& k : grp[now]) {
            int end_vtx = k.first;
            int weight = k.second;
            int cost = distance[now] + weight;

            if (distance[end_vtx] > cost) {
                distance[end_vtx] = cost;
                pq.push({ -cost, end_vtx });
            }
        }
    }

    return distance;
}

void boj_1753() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int V, E, K;
    cin >> V >> E >> K;

    vector<vector<pair<int, int>>> grp(V + 1);
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;

        grp[u].push_back(make_pair(v, w));
    }

    vector<int>&& distance = dijkstra(grp, K);
    for (int i = 1; i <= V; i++) {
        string val = distance[i] == INF ? "INF" : to_string(distance[i]);
        cout << val << "\n";
    }
}