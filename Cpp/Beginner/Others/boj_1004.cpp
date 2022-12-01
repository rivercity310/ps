//
// Created by seungsu on 12/1/22.
//

#include <iostream>
#define endl "\n"

using namespace std;

void boj_1004() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int x1, y1, x2, y2, n;
        cin >> x1 >> y1 >> x2 >> y2 >> n;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int cx, cy, r;
            cin >> cx >> cy >> r;

            int dist1 = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
            bool in1 = dist1 < r * r;
            int dist2 = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);
            bool in2 = dist2 < r * r;

            if (in1 != in2) cnt++;
        }

        cout << cnt << endl;
    }
}