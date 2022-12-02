//
// Created by seungsu on 12/2/22.
//

#include <iostream>

using namespace std;

static pair<int, int> len[12];

void boj_2477() {
    int k, d, l, big_area, small_area;

    cin >> k;

    for (int i = 0; i < 6; i++) {
        cin >> d >> l;
        len[i] = len[i + 6] = { d,l };
    }

    for (int i = 3; i < 12; i++) {
        if (len[i].first == len[i - 2].first
            && len[i - 1].first == len[i - 3].first) {

            big_area = len[i + 1].second * len[i + 2].second;
            small_area = len[i - 1].second * len[i - 2].second;

            break;
        }
    }
    cout << k * (big_area - small_area);
}