#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
[ 트리 지름 구하기 ]
 임의의 정점 v1, v1에서 가장 먼 정점 v2, v2에서 가장 먼 정점 v3라 할 때,
 v2와 v3를 연결하면 트리의 지름이 된다.
 */

constexpr int MAX = 100001;
static int max_distance = 0;
static int target = 0;
static bool visited[MAX];
static vector<pair<int, int>> tree[MAX];

/* node는 임의의 정점, sum은 거리 합 */
static void dfs(int node, int sum) {
    if (visited[node])
        return;

    if (max_distance < sum) {
        max_distance = sum;
        target = node;
    }

    visited[node] = true;

    for (int i = 0; i < tree[node].size(); i++) {
        int next = tree[node][i].first;
        int weight = tree[node][i].second;

        if (!visited[next])
            dfs(next, sum + weight);
    }
}

static void solve() {
    /* 이 함수가 종료되면 target에는 임의의 정점 1(v1)로부터 가장 먼 노드(v2)가 설정, max_distance에는 v1과 v2 사이 최대 거리 값이 설정됨*/
    dfs(2, 0);

    fill(visited, visited + MAX, false);

    /* 이 함수가 종료되면 target에는 v2에서 가장 먼 노드가, max_distance에는 가장 긴 거리값이 설정됨 */
    dfs(target, 0);

    cout << max_distance;
}

void boj_1167() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int v;
    cin >> v;

    while (v--) {
        int u;
        cin >> u;

        while (1) {
            int v;
            cin >> v;

            if (v == -1) break;

            int w;
            cin >> w;

            tree[u].push_back(make_pair(v, w));
        }
    }

    solve();
}