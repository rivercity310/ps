//
// Created by seungsu on 22. 11. 18.
//

#include <iostream>
#include <algorithm>

using namespace std;

void big_number_test() {
    int n, m, k;
    cin >> n >> m >> k;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    std::sort(arr, arr + n, [](int a, int b) {
        return a > b;
    });

    int rst = ((k * arr[0] + arr[1]) * (m / (k + 1))) + (arr[0] * (m % (k + 1)));
    cout << rst;
    
    delete[] arr;
}
