//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void card_game_test() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> v(n, vector<int>(m));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> v[i][j];

    int ans = 0;
    for (vector<int>& tmp : v) {
        int k = *std::min_element(tmp.begin(), tmp.end());
        ans = max(ans, k);
    }

    cout << ans;
}
