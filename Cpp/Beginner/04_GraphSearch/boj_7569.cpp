//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static vector<vector<vector<int>>> mat;
static vector<pair<pair<int, int>, int>> pt;
static int dh[] = { -1, 0, 1 };
static int dx[] = { -1, 1, 0, 0 };
static int dy[] = { 0, 0, -1, 1 };
static int ans = 0;

class Now {
public:
    int h, n, m, d;
    Now(int h, int n, int m, int d) {
        this->h = h;
        this->n = n;
        this->m = m;
        this->d = d;
    }
};

static void solve(int h, int n, int m) {
    queue<Now> q;
    for (auto ppr : pt)
        q.push(Now(ppr.first.first, ppr.first.second, ppr.second, 0));

    while (!q.empty()) {
        Now now = q.front();
        int nh = now.h;
        int nx = now.n;
        int ny = now.m;
        int nd = now.d;
        ans = nd;
        q.pop();

        for (int i = 0; i < 3; i++) {
            int th = dh[i] + nh;

            if (th < 0 || th >= h)
                continue;

            if (th == nh) {     // 높이 이동이 없을 경우
                for (int j = 0; j < 4; j++) {
                    int tx = dx[j] + nx;
                    int ty = dy[j] + ny;

                    if (tx < 0 || ty < 0 || tx >= n || ty >= m)
                        continue;

                    if (mat[th][tx][ty] == 0) {
                        mat[th][tx][ty] = 1;
                        q.push(Now(th, tx, ty, nd + 1));
                    }
                }
            }

            else {
                if (mat[th][nx][ny] == 0) {
                    mat[th][nx][ny] = 1;
                    q.push(Now(th, nx, ny, nd + 1));
                }
            }
        }
    }
}

static bool check_arr(int h, int n, int m) {
    for (int i = 0; i < h; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++)
                if (mat[i][j][k] == 0)
                    return false;

    return true;
}

void boj_7569() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, n, h;
    cin >> m >> n >> h;

    mat = vector<vector<vector<int>>>(h, vector<vector<int>>(n, vector<int>(m)));

    for (int i = 0; i < h; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < m; k++) {
                cin >> mat[i][j][k];
                if (mat[i][j][k] == 1)
                    pt.push_back(make_pair(make_pair(i, j), k));
            }

    solve(h, n, m);

    if (check_arr(h, n, m)) cout << ans;
    else cout << -1;
}