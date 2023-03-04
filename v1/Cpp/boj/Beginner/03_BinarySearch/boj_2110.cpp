//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 간격 x로 주어진 공유기 c개를 모두 설치할 수 있으면 된다.
static int solve(vector<int>& v, int c) {
    int left = 1;
    int right = v.back() - v.front();
    int ans = -1;

    while (left <= right) {
        int mid = (left + right) / 2;
        int router = 1;
        int last = 0, next = 1;

        while (next < v.size() && router < c) {
            if (v[next] >= v[last] + mid) {
                router++;
                last = next;
                next = last + 1;
            }
            else next++;
        }

        if (router < c) right = mid - 1;
        else if (router > c) left = mid + 1;
        else {
            ans = mid;      // 임시 정답을 저장하고, 간격 늘려서 더 테스트 해보기
            left = mid + 1;
        }
    }

    return ans;
}

void boj_2110() {
    int n, c;
    cin >> n >> c;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    std::sort(v.begin(), v.end());
    cout << solve(v, c);
}