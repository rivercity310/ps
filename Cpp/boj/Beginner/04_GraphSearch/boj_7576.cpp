//
// Created by seungsu on 12/2/22.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static vector<vector<int>> mat;
static vector<pair<int, int>> pt;
static const vector<int> dx = { -1, 1, 0, 0 };
static const vector<int> dy = { 0, 0, -1, 1 };
static int ans = 0;

class Point {
private:
    int x, y, days;

public:
    Point(int x, int y, int days) {
        this->x = x;
        this->y = y;
        this->days = days;
    }

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

    int getDays() const {
        return days;
    }
};

static bool check_arr() {
    for (int i = 0; i < mat.size(); i++)
        for (int j = 0; j < mat[0].size(); j++)
            if (mat[i][j] == 0)
                return false;

    return true;
}

static void solve() {
    queue<Point> q;
    for (pair<int, int>& pr : pt)
        q.push(Point(pr.first, pr.second, 0));

    while (!q.empty()) {
        Point pnt = q.front();
        int nx = pnt.getX();
        int ny = pnt.getY();
        int nd = pnt.getDays();
        ans = nd;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int tx = nx + dx[i];
            int ty = ny + dy[i];

            if (tx < 0 || ty < 0 || tx >= mat.size() || ty >= mat[nx].size())
                continue;

            if (mat[tx][ty] == 0) {
                mat[tx][ty] = 1;
                q.push(Point(tx, ty, nd + 1));
            }
        }
    }
}

void boj_7576() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, n;
    cin >> m >> n;

    mat = vector<vector<int>>(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> mat[i][j];

            if (mat[i][j] == 1)
                pt.push_back(make_pair(i, j));
        }
    }

    solve();

    if (check_arr()) cout << ans;
    else cout << -1;
}