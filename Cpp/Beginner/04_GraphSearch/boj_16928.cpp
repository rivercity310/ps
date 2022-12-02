//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
constexpr int MAX = 101;

static vector<int> grp(MAX);
static vector<int> dist(MAX, 1e9);

static void solve() {
    queue<int> q;

    q.push(1);
    dist[1] = 0;

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int i = 1; i <= 6; i++) {
            int next = now + i;

            if (next > 100)
                continue;

            int evt = grp[next];

            if (grp[next]) {
                if (dist[evt] > dist[now] + 1 || dist[evt] == 1e9) {
                    dist[evt] = dist[now] + 1;
                    q.push(evt);
                }
            }

            else {
                if (dist[next] == 1e9 || dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    q.push(next);
                }
            }
        }
    }
}


void boj_16928() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n + m; i++) {
        int x, y;
        cin >> x >> y;
        grp[x] = y;
    }

    solve();

    cout << dist[MAX - 1];
}