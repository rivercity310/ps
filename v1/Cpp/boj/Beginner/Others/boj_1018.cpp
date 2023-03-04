//
// Created by seungsu on 11/29/22.
//

#include <iostream>
#include <vector>

using namespace std;

vector<int> arr1 = {1, 0, 1, 0, 1, 0, 1, 0};
vector<int> arr2 = {0, 1, 0, 1, 0, 1, 0, 1};

static int counter(vector<string>& v, int row, int col) {
    int black_first = 0;
    int white_first = 0;

    // black_first
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            int val = v[i + row][j + col] == 'W' ? 1 : 0;

            // 홀수행
            if (i % 2 == 0) {
                if (arr2[j] != val) black_first++;
            }

            else {
                if (arr1[j] != val) black_first++;
            }
        }
    }

    // white_first
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            int val = v[i + row][j + col] == 'W' ? 1 : 0;

            // 홀수행
            if (i % 2 == 0) {
                if (arr1[j] != val) white_first++;
            }

            else {
                if (arr2[j] != val) white_first++;
            }
        }
    }

    return min(black_first, white_first);
}

void boj_1018() {
    int n, m;
    cin >> n >> m;

    // white = 1, black = 0
    vector<string> v;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        v.push_back(s);
    }

    int ans = 123456;
    for (int i = 0; i <= n - 8; i++) {
        for (int j = 0; j <= m - 8; j++) {
            ans = min(ans, counter(v, i, j));
        }
    }

    cout << ans;
}