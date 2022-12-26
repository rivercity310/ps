//
// Created by seungsu on 22. 11. 23.
//

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

static void prt_arr(vector<vector<int>>& grp) {
    for (int i = 0; i < grp.size(); i++) {
        for (int j = 0; j < grp[i].size(); j++)
            printf("%-5d", grp[i][j]);
        putchar('\n');
    }

    cout << "\n";
}

static void solve(vector<vector<int>>& grp, int n, int m) {
    // 사방탐색을 위한 벡터
    int dx[] = {-1, 1, 0 , 0};
    int dy[] = {0, 0, -1, 1};

    queue<pair<int, int>> q;
    q.push(make_pair(0, 0));

    while (!q.empty()) {
        pair<int, int> pr = q.front();
        q.pop();

        int x = pr.first;
        int y = pr.second;

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || ty < 0 || tx >= n || ty >= m)
                continue;

            if (grp[tx][ty] == 1) {
                grp[tx][ty] = grp[x][y] + 1;
                q.push(make_pair(tx, ty));
            }

            /*
             * 단축 조건 : 찾으면 바로 종료
            if (tx == n - 1 && ty == m - 1) {
                cout << grp[tx][ty];
                return;
            }
             */
        }
    }

    grp[0][0] = 1;
    prt_arr(grp);
    cout << grp[n - 1][m - 1];
}

void maze_escape_test() {
    // ios::sync_with_stdio(0);
    // cin.tie(0);
    // cout.tie(0);    -> printf와 cout간 순서가 보장되지 않음

    int n, m;
    cin >> n >> m;

    vector<vector<int>> grp(n, vector<int>(m));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            scanf("%1d", &grp[i][j]);

    cout << "[ 입력 완료 ]" << "\n";
    prt_arr(grp);

    solve(grp, n, m);
}