//
// Created by seungsu on 12/27/22.
//

#include <bits/stdc++.h>
using namespace std;

static vector<vector<int>> v;
static vector<int> parent;
static vector<int> depth;

static int lca(int a, int b) {
    int depthA = depth[a];
    int depthB = depth[b];

    while (depthA > depthB) {
        a = parent[a];
        depthA--;
    }

    while (depthB > depthA) {
        b = parent[b];
        depthB--;
    }

    while (a != b) {
        a = parent[a];
        b = parent[b];
    }

    return a;
}

static void dfs(int node, int val, int p) {
    depth[node] = val;
    parent[node] = p;

    for (int next : v[node]) {
        if (next != p) {
            dfs(next, val + 1, node);
        }
    }
}

void boj_11437() {
    int n;
    cin >> n;

    v = vector<vector<int>>(n + 1, vector<int>());
    parent = vector<int>(n + 1, 0);
    depth = vector<int>(n + 1, 0);

    for (int i = 1; i < n; i++) {
        int a, b;
        cin >> a >> b;

        v[a].push_back(b);
        v[b].push_back(a);
    }

    dfs(1, 1, 0);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        cout << lca(a, b) << "\n";
    }
}