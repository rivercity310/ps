#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

static int find_index(vector<string>& v, string key) {
    for (int i = 0; i < v.size(); i++)
        if (v[i] == key)
            return i;

    return -1;
}

static vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    const int n = id_list.size();
    vector<int> answer;
    answer.assign(n, 0);

    vector<int> reportee_cnt(n, 0);
    vector<vector<bool>> isReported(n, vector<bool>(n, false));     // i번째에 해당하는 유저가 j번째에 해당하는 유저를 신고 -> 1회만 가능하니까 한번 신고후 true 값

    for (string str : report) {
        stringstream ss(str);
        string a, b;
        ss >> a >> b;

        int reporter_index = find_index(id_list, a);
        int reportee_index = find_index(id_list, b);

        if (!isReported[reporter_index][reportee_index]) {
            isReported[reporter_index][reportee_index] = true;
            reportee_cnt[reportee_index]++;
        }
    }

    for (int a = 0; a < n; a++)
        if (reportee_cnt[a] >= k)
            for (int i = 0; i < n; i++)
                if (isReported[i][a] == true) {
                    answer[i]++;
                }

    return answer;
}

// 다른 사람의 풀이
static vector<int> solution2(vector<string> id_list, vector<string> report, int k) {
    const int n = id_list.size();
    map<string, int> Conv;
    for (int i = 0; i < n; i++) Conv[id_list[i]] = i;

    vector<pair<int, int>> v;

    // 중복 제거 코드
    sort(report.begin(), report.end());
    report.erase(unique(report.begin(), report.end()), report.end());

    // 문자열 분해
    for (const auto& s : report) {
        stringstream in(s);
        string a, b;
        in >> a >> b;
        v.push_back(make_pair(Conv[a], Conv[b]));
    }

    // 구조 분해 할당 (C++17)
    vector<int> cnt(n), ret(n);
    for (const auto& [a, b] : v) cnt[b]++;
    for (const auto& [a, b] : v) if (cnt[b] >= k) ret[a]++;

    return ret;
}

void bl2022_ex1() {
    fastio;
    vector<string> id_list = { "muzi", "frodo", "apeach", "neo" };
    vector<string> report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
    int k = 2;

    for (int ans : solution(id_list, report, k))
        cout << ans << " ";
}