//
// Created by seungsu on 22. 11. 19.
//

/* 회의실 배정 */

#include <iostream>
#include <queue>

using namespace std;

void boj_1931() {
    int n;
    cin >> n;

    // C++의 우선순위 큐는 기분 최대힙 -> 최소힙으로 사용하려면 -를 붙여준다.
    priority_queue<pair<int, int>> pq;

    for (int i = 0; i < n; i++) {
        int start, end;
        cin >> start >> end;
        pq.push(make_pair(-end, start));
    }

    int cnt = 0;
    int last = -1;

    while (!pq.empty()) {
        auto p = pq.top();
        pq.pop();

        int start = p.second;
        int end = -p.first;

        if (start >= last) {
            last = end;
            cnt++;
        }
    }

    cout << cnt;
}