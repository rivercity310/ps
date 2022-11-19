//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void boj_13305() {
    int n;
    cin >> n;

    vector<int> len(n - 1);
    for (int i = 0; i < len.size(); i++)
        cin >> len[i];

    vector<int> prices(n);
    for (int i = 0; i < prices.size(); i++)
        cin >> prices[i];

    int min_price = 1e9;
    unsigned long long total = 0;

    for (int i = 0; i < n - 1; i++) {
        min_price = std::min(min_price, prices[i]);
        total += (unsigned long long)len[i] * (unsigned long long)min_price;
    }

    cout << total;
}