#include <iostream>
#include <vector>

#define endl "\n"

using namespace std;

typedef unsigned long long ull;

vector<ull> preSum;
vector<ull> cnt;      // m으로 나누었을 때 나머지가 같은 부분합 카운트

void boj_10986() {
    int n, m;
    cin >> n >> m;

    preSum.resize(n + 1, 0);
    cnt.resize(m, 0);

    for (int i = 1; i <= n; i++) {
        ull x;
        cin >> x;

        preSum[i] = preSum[i - 1] + x;
        cnt[preSum[i] % m]++;
    }

    cout << "[ presum ]" << "\n";
    for (int i = 0; i < preSum.size(); i++)
        cout << preSum[i] << " ";
    cout << "\n";

    cout << "[ cnt ]" << "\n";
    for (int k : cnt)
        cout << k << " ";
    cout << "\n";

    ull ans = cnt[0];                            // Combination(cnt[0], 0) -> m으로 나누었을 때 나머지가 0인 것들이므로 그대로 더해준다.
    for (int i = 0; i < m; i++)
        if (cnt[i] >= 2)
            ans += (cnt[i] * (cnt[i] - 1)) / 2;  // Combination(cnt[i], 2) -> m으로 나누었을 때 나머지가 r인 두 부분수열을 뺀 부분수열은 m으로 나누었을 때 나머지가 0이 된다.

    cout << ans << endl;
}