//
// Created by seungsu on 12/1/22.
//

#include <iostream>
#include <queue>

using namespace std;


static int bfs(int x1, int y1, int x2, int y2, int n) {
    if (x1 == x2 && y1 == y2)
        return 0;

    vector<vector<int>> m(n, vector<int>(n, 0));
    queue<pair<int, int>> q;
    q.push(make_pair(x1, y1));

    int dx[] = { -2, -2,  -1, -1,  1, 1, 2, 2 };
    int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        int nx = now.first;
        int ny = now.second;

        for (int i = 0; i < 8; i++) {
            int tx = nx + dx[i];
            int ty = ny + dy[i];

            if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                continue;

            if (m[tx][ty] == 0) {
                m[tx][ty] = m[nx][ny] + 1;
                q.push(make_pair(tx, ty));
            }
        }
    }

    return m[x2][y2];
}

void boj_7562() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n, x1, y1, x2, y2;
        cin >> n >> x1 >> y1 >> x2 >> y2;

        cout << bfs(x1, y1, x2, y2, n) << "\n";
    }
}