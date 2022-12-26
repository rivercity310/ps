//
// Created by seungsu on 11/30/22.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void boj_3273() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++)
        cin >> a[i];

    std::sort(a.begin(), a.end());

    int x;
    cin >> x;

    int left = 0;
    int right = n - 1;
    int cnt = 0;

    while (left < right) {
        int sum = a[left] + a[right];

        if (sum == x) {
            cnt++;
            right--;
        }
        else if (sum > x) right--;
        else left++;
    }

    cout << cnt;
}