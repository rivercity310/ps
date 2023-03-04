//
// Created by seungsu on 11/30/22.(
//

#include <iostream>

// 지수 법칙
// a^(n + m) = a^n + a^m

// 모듈러 성질
// (a x b) mod C = (a mod C x b mod C) mod C

using namespace std;
typedef unsigned long long ull;

static ull solve(ull a, ull b, ull c) {
    if (b == 1) return a % c;
    if (b & 1) return ((a % c) * solve(a, b - 1, c) % c);
    else return ((solve(a, b / 2, c) % c) * (solve(a, b / 2, c) % c) % c);
}

static ull solve2(ull a, ull b, ull c) {
    if (b == 1) return a % c;

    ull tmp = solve2(a, b / 2, c);

    if (b & 1) return tmp * tmp % c * a % c;
    return tmp * tmp % c;
}

void boj_1629() {
    ull a, b, c;
    cin >> a >> b >> c;

    cout << solve2(a, b, c);
}