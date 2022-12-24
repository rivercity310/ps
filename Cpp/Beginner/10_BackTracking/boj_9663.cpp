//
// Created by seungsu on 12/24/22.
//

#include <bits/stdc++.h>
using namespace std;

static int N;
static int vx[16], vy[16];

static int solve(int y, int x) {
    // 가지치기(back tracking)
    for (int i = 0; i < y; i++) {
        if (x == vx[i]) return 0;   // 세로 겹침
        if (y == vy[i]) return 0;   // 가로 겹침
        if (abs(x - vx[i]) == abs(y - vy[i])) return 0;  // 대각 겹침
    }

    // 종료조건
    if (y == N - 1) return 1;

    // 말의 위치 기억
    vy[y] = y, vx[y] = x;

    int r = 0;
    for (int i = 0; i < N; i++) r += solve(y + 1, i);
    return r;
}

void boj_9663() {
    cin >> N;
    int r = 0;
    for (int i = 0; i < N; i++) r += solve(0, i);
    cout << r;
}