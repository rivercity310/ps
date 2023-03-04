//
// Created by seungsu on 22. 11. 19.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void boj_18870() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    vector<int> w(n);

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v[i] = x;
        w[i] = x;
    }

    // erase <- unique : 붙어 있는 중복값 제거 (모든 중복 없애려면 정렬 후 사용)
    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());

    cout << "unique" << "\n";
    for (int k : v)
        cout << k << " ";
    cout << endl;

    // lower_bound, upper_bound : 주어진 범위에서 이진 탐색 수행 후 이터레이터 반환
    // 인덱스를 알고싶다면 v.begin()을 빼준다
    for (int i = 0; i < w.size(); i++)
        cout << lower_bound(v.begin(), v.end(), w[i]) - v.begin() << " ";
}

void boj_18870_fail2() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    vector<int> ans(n);
    int cnt = 0;

    while (true) {
        int min_iter = *std::min_element(v.begin(), v.end());
        if (min_iter == 1e9 + 1)
            break;

        for (int j = 0; j < n; j++) {
            if (v[j] == min_iter) {
                ans[j] = cnt;
                v[j] = 1e9 + 1;
            }
        }

        cnt++;
    }

    for (int k : ans)
        cout << k << " ";
}

/* O(N^2) : 시간 초과 */
void boj_18870_fail() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    int cnt = 0;
    vector<int> ans(n);
    vector<bool> visited(n, false);

    for (int i = 0; i < n; i++) {
        int min_value = 1e9 + 1;

        for (int j = 0; j < n; j++)
            if (v[j] < min_value && !visited[j])
                min_value = v[j];

        for (int j = 0; j < n; j++) {
            if (v[j] == min_value && !visited[j]) {
                ans[j] = cnt;
                visited[j] = true;
            }
        }

        cnt++;
    }

    for (int v : ans)
        cout << v << " ";
}