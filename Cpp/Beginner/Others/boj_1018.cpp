//
// Created by seungsu on 11/29/22.
//

#include <iostream>
#include <vector>

using namespace std;

vector<int> arr1 = {1, 0, 1, 0, 1, 0, 1, 0};
vector<int> arr2 = {0, 1, 0, 1, 0, 1, 0, 1};

void boj_1018() {
    int n, m;
    cin >> n >> m;

    // white = 1, black = 0
    vector<vector<int>> v(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &v[i][j]);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            cout << v[i][j] << " ";
        cout << "\n";
    }
}