//
// Created by seungsu on 11/30/22.
//
#include <iostream>
#include <vector>

using namespace std;

void boj_2740() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    vector<vector<int>> a;
    vector<vector<int>> b;

    for (int t = 0; t < 2; t++) {
        int n, m;
        cin >> n >> m;

        if (t == 0) a = vector<vector<int>>(n, vector<int>(m));
        else b = vector<vector<int>>(n, vector<int>(m));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (t == 0) cin >> a[i][j];
                else cin >> b[i][j];
            }
        }
    }

    for (int k = 0; k < a.size(); k++) {
        for (int i = 0; i < b[0].size(); i++) {
            int tmp = 0;
            for (int j = 0; j < a[0].size(); j++) {
                tmp += a[k][j] * b[j][i];
            }

            cout << tmp << " ";
        }

        cout << "\n";
    }
}