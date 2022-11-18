//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <numeric>

using namespace std;

void exchange_test() {
    int n;
    cin >> n;

    int coins[] = {500, 100, 50, 10};
    int coins_count[] = {0, 0, 0, 0};
    int size = 4;

    for (int i = 0; i < size; i++) {
        coins_count[i] += n / coins[i];
        n %= coins[i];
    }

    int ans = std::accumulate(coins_count, coins_count + size, 0);
    cout << "[ 동전 개수 ]" << "\n";
    cout << ans;
}