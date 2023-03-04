//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

static int get_mode(vector<int>& v) {
    vector<int> fq_minus(4001);
    vector<int> fq_plus(4001);

    for (int k : v) {
        if (k < 0) fq_minus[-k]++;
        else fq_plus[k]++;
    }

    auto fq_minus_most = max_element(fq_minus.begin(), fq_minus.end());
    auto fq_plus_most = max_element(fq_plus.begin(), fq_plus.end());
    int most_val = max(*fq_minus_most, *fq_plus_most);

    bool is_minus = false;
    int is_second = 0;
    int tmp;

    for (int i = 4000; i > 0; i--) {
        if (fq_minus[i] == most_val) {
            if (is_second == 1)
                return -i;

            is_minus = true;
            tmp = i;
            is_second++;
        }
    }

    for (int i = 0; i < 4001; i++) {
        if (fq_plus[i] == most_val) {
            if (is_second == 1)
                return i;

            is_minus = false;
            tmp = i;
            is_second++;
        }
    }

    if (is_minus) return -tmp;
    else return tmp;
}

void boj_2108() {
    ios::sync_with_stdio(0);  // stdio와 iostream의 동기화 비활성화
    cin.tie(0);              // cin과 cout의 묶음을 풀어준다
    cout.tie(0);

    int n;
    cin >> n;

    int sum = 0;
    vector<int> v(n);

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        sum += x;
        v[i] = x;
    }

    sort(v.begin(), v.end());

    // 내림 함수를 이용해 반올림 구현
    // 최빈값 구하기 -> 정수의 범위가 4000밖에 안되고 양수 범위 -> 계수 정렬 개념
    int ave = floor(((double)sum / n) + 0.5);
    int median = v[n / 2];
    int mode = get_mode(v);
    int range = v[n - 1] - v[0];

    cout << ave << "\n";
    cout << median << "\n";
    cout << mode << "\n";
    cout << range;
}