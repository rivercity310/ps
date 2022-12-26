//
// Created by seungsu on 12/25/22.
//

#include <bits/stdc++.h>
using namespace std;

static int dist = 1e9;
static int N;
static int S[20][20];
static bool C[20];

static void dfs(int depth, int start) {
    if (start == N) return;

    if (depth == N / 2) {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (C[i] && C[j]) startScore += S[i][j];
                if (!C[i] && !C[j]) linkScore += S[i][j];
            }
        }

        dist = min(abs(startScore - linkScore), dist);
        return;
    }

    C[start] = true;
    dfs(depth + 1, start + 1);
    C[start] = false;
    dfs(depth, start + 1);
}

void boj_14889() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> S[i][j];

    dfs(0, 0);
    cout << dist;
}