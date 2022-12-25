//
// Created by seungsu on 12/24/22.
//

#include <bits/stdc++.h>
using namespace std;

static int N;
static int max_val = -(1e9 + 1);
static int min_val = 1e9 + 1;
static vector<int> nums;
static vector<int> ops;

static void solve(int depth, int result) {
    if (depth == N) {
        max_val = max(max_val, result);
        min_val = min(min_val, result);
        return;
    }

    for (int i = 0; i < ops.size(); i++) {
        if (ops[i] > 0) {
            ops[i]--;

            if (i == 0) solve(depth + 1, result + nums[depth]);
            else if (i == 1) solve(depth + 1, result - nums[depth]);
            else if (i == 2) solve(depth + 1, result * nums[depth]);
            else if (i == 3) solve(depth + 1, result / nums[depth]);

            ops[i]++;
        }
    }
}

void boj_14888() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N;
    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    for (int i = 0; i < 4; i++) {
        int x;
        cin >> x;
        ops.push_back(x);
    }

    solve(1, nums[0]);

    cout << max_val << "\n";
    cout << min_val;
}