//
// Created by seungsu on 12/3/22.
//

#include <iostream>
#include <vector>

using namespace std;

static int gcd(int a, int b) {
    if (a % b == 0) return b;
    return gcd(b, a % b);
}

static long long solve(vector<int>& v) {
    long long sum = 0;
    for (int i = 0; i < v.size() - 1; i++)
        for (int j = i + 1; j < v.size(); j++)
            sum += gcd(v[i], v[j]);

    return sum;
}

void boj_9613() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<int> v(n);
        for (int i = 0; i < n; i++)
            cin >> v[i];

        cout << solve(v) << "\n";
    }
}