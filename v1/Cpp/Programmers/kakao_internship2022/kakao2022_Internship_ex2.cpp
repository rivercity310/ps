//
// Created by seungsu on 12/7/22.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;
typedef unsigned long long ull;

static int solution(vector<ull> q1, vector<ull> q2) {
    int ans = 0;
    int now1 = 0;
    int now2 = 0;

    while (now1 < q1.size() || now2 < q2.size()) {
        ull sum1 = accumulate(q1.begin() + now1, q1.end(), 0);
        ull sum2 = accumulate(q2.begin() + now2, q2.end(), 0);
        ull target = (sum1 + sum2) / 2;

        if (sum1 == sum2)
            return ans;

        ull dist1 = sum1 - target;
        ull dist2 = sum2 - target;

        if (dist1 > dist2) {        // q1의 원소 합이 더 큰 경우 -> q2로 큰 원소를 전달해야함
            if (q1[now1] > q2[now2]) {
                q2.push_back(q1[now1++]);
            }

            else {
                q1.push_back(q2[now2++]);
            }
        }

        else {                      // q1의 원소 합이 더 작은 경우 -> q2로부터 더 큰 원소를 받아와야 함
            if (q1[now1] > q2[now2]) {
                q2.push_back(q1[now1++]);
            }

            else {
                q1.push_back(q2[now2++]);
            }
        }

        ans++;
    }

    return -1;
}

void internship_ex2() {
    vector<ull> q1 = { 1, 2, 1, 2 };
    vector<ull> q2 = { 1, 10, 1, 2 };

    cout << solution(q1, q2);
}