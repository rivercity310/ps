//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
constexpr int INF = 1e8;

static int solve(vector<vector<pair<int, int>>>& grp, int start, int end) {
    priority_queue<pair<int, int>> pq;
    vector<int> distance(grp.size(), INF);

    pq.push(make_pair(0, start));
    distance[start] = 0;

    while (!pq.empty()) {
        pair<int, int> pr = pq.top();
        int now = pr.second;
        int dist = -pr.first;
        pq.pop();

        if (distance[now] < dist)
            continue;

        for (auto& tmp : grp[now]) {
            int next = tmp.first;
            int weight = tmp.second;
            int cost = distance[now] + weight;

            if (distance[next] > cost) {
                distance[next] = cost;
                pq.push(make_pair(-cost, next));
            }
        }
    }

    return distance[end];
}

void boj_9370() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int n, m, t;    // 교차로, 도로, 목적지 후보 개수
        cin >> n >> m >> t;

        int s, g, h;    // 출발지, 교차로(g, h)
        cin >> s >> g >> h;

        vector<vector<pair<int, int>>> grp(n + 1);
        vector<int> lst(t);

        for (int i = 0; i < m; i++) {
            int a, b, d;
            cin >> a >> b >> d;

            grp[a].push_back(make_pair(b, d));
            grp[b].push_back(make_pair(a, d));
        }

        for (int i = 0; i < t; i++)
            cin >> lst[i];

        // start->end 거리가 min(start -> g -> h -> end, start -> h -> g -> end)과 같은 목적지들
        vector<int> ans;

        for (int k : lst) {
            int dist = solve(grp, s, k);
            int tmp1 = solve(grp, s, g) + solve(grp, g, h) + solve(grp, h, k);
            int tmp2 = solve(grp, s, h) + solve(grp, h, g) + solve(grp, g, k);

            if (dist == min(tmp1, tmp2))
                ans.push_back(k);
        }

        sort(ans.begin(), ans.end());
        for (int v : ans)
            cout << v << " ";

        cout << "\n";
    }
}