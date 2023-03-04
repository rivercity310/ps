#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0)->cin.tie(0)

using namespace std;

static vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    int zero = 0;
    int cor = 0;
    int wrong = 0;
    int n = win_nums.size();

    for (int lotto : lottos) {
        if (lotto == 0) zero++;
        else if (std::find(win_nums.begin(), win_nums.end(), lotto) != win_nums.end()) cor++;
        else wrong++;
    }

    vector<int> ans;

    if (cor == n) ans = { 1, 1 };
    else if (wrong == n) ans = { 6, 6 };
    else if (zero == n) ans = { 1, 6 };
    else ans = { wrong + 1, wrong + zero + 1 };

    return ans;
}


void backend_ex1() {
    vector<int> lottos = { 45, 4, 35, 20, 3, 9 };
    vector<int> win_nums = { 20, 9, 3, 45, 4, 35 };
    vector<int> ans = solution(lottos, win_nums);
    for (int a : ans) cout << a << " ";
}