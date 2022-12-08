#include <iostream>
#include <string>
#include <vector>

using namespace std;
constexpr int DIV = 4;

static string solution(vector<string> survey, vector<int> choices) {
    vector<char> chr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    vector<int> cnt(8, 0);  // R, T, C, F, J, M, A, N 순서 카운트
    string ans = "";

    for (int i = 0; i < survey.size(); i++) {
        string str = survey[i];
        int a = choices[i];   // 점수

        // 1번 지표
        if (str == "RT" || str == "TR") {
            if (str[0] == 'R') {
                if (a < 4) cnt[0] += 4 - a;
                else if (a > 4) cnt[1] += a % DIV;
            }

            else {
                if (a < 4) cnt[1] += 4 - a;
                else if (a > 4) cnt[0] += a % DIV;
            }
        }

            // 2번 지표
        else if (str == "CF" || str == "FC") {
            if (str[0] == 'C') {
                if (a < 4) cnt[2] += 4 - a;
                else if (a > 4) cnt[3] += a % DIV;
            }

            else {
                if (a < 4) cnt[3] += 4 - a;
                else if (a > 4) cnt[2] += a % DIV;
            }
        }

            // 3번 지표
        else if (str == "JM" || str == "MJ") {
            if (str[0] == 'J') {
                if (a < 4) cnt[4] += 4 - a;
                else if (a > 4) cnt[5] += a % DIV;
            }

            else {
                if (a < 4) cnt[5] += 4 - a;
                else if (a > 4) cnt[4] += a % DIV;
            }
        }

            // 4번 지표
        else if (str == "AN" || str == "NA") {
            if (str[0] == 'A') {
                if (a < 4) cnt[6] += 4 - a;
                else if (a > 4) cnt[7] += a % DIV;
            }

            else {
                if (a < 4) cnt[7] += 4 - a;
                else if (a > 4) cnt[6] += a % DIV;
            }
        }
    }

    // (0, 1), (2, 3), (4, 5), (6, 7)
    for (int i = 1; i < cnt.size(); i += 2) {
        if (cnt[i - 1] > cnt[i]) ans += chr[i - 1];
        else if (cnt[i - 1] == cnt[i]) {
            ans += chr[i - 1] < chr[i] ? chr[i - 1] : chr[i];
        }
        else ans += chr[i];
    }

    return ans;
}

void internship_ex1() {
    vector<string> survey = {"AN", "CF", "MJ", "RT", "NA"};
    vector<int> choices = {5, 3, 2, 7, 5};

    cout << solution(survey, choices);
}