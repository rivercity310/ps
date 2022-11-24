//
// Created by seungsu on 22. 11. 24.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
constexpr int INF = 1e9;

class Disjoint_Set {
private:
    int* parent;

public:
    Disjoint_Set(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    ~Disjoint_Set() {
        delete[] parent;
    }

    int find_parent(int x) {
        if (parent[x] != x)
            return find_parent(parent[x]);
        return x;
    }

    void union_parent(int a, int b) {
        int ra = find_parent(a);
        int rb = find_parent(b);

        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;
    }
};

static void solve(vector<vector<int>>& grp) {
    vector<vector<int>> dist_table(grp.size(), vector<int>(grp.size(), INF));

    for (int a = 1; a < grp.size(); a++)
        for (int b = 1; b < grp.size(); b++)
            if (a == b)
                dist_table[a][b] = 0;

    for (int k = 1; k < grp.size(); k++)
        for (int a = 1; a < grp.size(); a++)
            for (int b = 1; b < grp.size(); b++)
                dist_table[a][b] = min(dist_table[a][b], grp[a][k] + grp[k][b]);

    // Kruskal : 출발지와 목적지를 알아야 함..
    int cnt = 0;
    for (int i = 1; i < grp.size(); i++) {
        Disjoint_Set dset(grp.size());

        for (int j = 1; j < grp.size(); j++) {
            if (i == j) continue;

            int src = i;
            int dst = j;

            if (dset.find_parent(src) != dset.find_parent(dst)) {
                dset.union_parent(src, dst);
                cnt += grp[src][dst];
            }

            else break;
        }
    }
}

void boj_1956() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int v, e;
    cin >> v >> e;

    vector<vector<int>> grp(v + 1, vector<int>(v + 1, 0));
    while (e--) {
        int a, b, c;
        cin >> a >> b >> c;
        grp[a][b] = c;
    }

    solve(grp);
}