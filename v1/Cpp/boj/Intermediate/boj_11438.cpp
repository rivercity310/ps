#include <bits/stdc++.h>
using namespace std;
constexpr int LOG = 21;

static int N, M;
static vector<int> depth;
static vector<bool> visited;
static vector<vector<int>> tree;
static vector<vector<int>> parent;

static int lca(int a, int b) {
    if (depth[a] > depth[b]) swap(a, b);

    for (int i = LOG - 1; i >= 0; i--)
        if (depth[b] - depth[a] >= (1 << i))
            b = parent[b][i];

    if (a == b) return a;

    for (int i = LOG - 1; i >= 0; i--) {
        if (parent[a][i] != parent[b][i]) {
            a = parent[a][i];
            b = parent[b][i];
        }
    }

    return parent[a][0];
}

static void dfs(int node, int dth) {
    visited[node] = true;
    depth[node] = dth;

    for (int next : tree[node]) {
        if (!visited[next]) {
            parent[next][0] = node;
            dfs(next, dth + 1);
        }
    }
}

static void set_parents() {
    dfs(1, 0);

    for (int i = 1; i < LOG; i++)
        for (int j = 1; j <= N; j++)
            parent[j][i] = parent[parent[j][i - 1]][i - 1];
}

void boj_11438() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N;

    depth = vector<int>(N + 1);
    visited = vector<bool>(N + 1);
    tree = vector<vector<int>>(N + 1, vector<int>());
    parent = vector<vector<int>>(N + 1, vector<int>(LOG));

    for (int i = 1; i < N; i++) {
        int a, b;
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    set_parents();
    cin >> M;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        cout << lca(a, b) << "\n";
    }
}