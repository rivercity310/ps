#include <iostream>
#include <vector>

#define endl "\n"

using namespace std;

constexpr int MAX = 1e6 + 1;

vector<unsigned long long> preSum(MAX, 0);
vector<unsigned long long> cnt(MAX, 0);

void boj_10986() {
    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        unsigned long long x;
        cin >> x;

        preSum[i] = (preSum[i - 1] + x) % m;
        cnt[preSum[i]]++;
    }

    unsigned long long ans = cnt[0];
    for (int i = 0; i < m; i++)
        if (cnt[i] >= 2)
            ans += (cnt[i] * (cnt[i] - 1)) / 2;

    cout << ans << endl;
}