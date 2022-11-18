//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>

using namespace std;

void number_one_test() {
    int n, k;
    cin >> n >> k;

    int cnt = 0;
    while (n != 1) {
        if (n % k == 0) n /= k;
        else n -= 1;
        cnt++;
    }

    cout << cnt;
}
