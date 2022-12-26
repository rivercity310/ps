//
// Created by seungsu on 12/3/22.
//

#include <iostream>

using namespace std;
typedef unsigned long long ull;

static ull gcd(ull a, ull b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

void boj_1850() {
    string a, b;
    cin >> a >> b;

    ull ua = 0;
    int tmp = 1;

    for (int i = 0; i < a.size(); i++)

    cout << gcd(111, 111111);
}

void boj_1234() {
    int n = 10;
    for (int i = 0; i < n; i++) {
        if (i == 5) cout << i;
        else cout << i * 2;
        cout << " ";
    }
}