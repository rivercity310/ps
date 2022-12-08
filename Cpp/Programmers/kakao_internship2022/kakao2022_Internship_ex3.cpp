//
// Created by seungsu on 12/7/22.
//

#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

static vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    vector<int> answer;

    for (int start : gates) {
        stack<int> stk;
        vector<int> visited(n + 1, false);
        vector<int> intencities;

        visited[start] = true;
        stk.push(start);

        while (!stk.empty()) {
            int now = stk.top();
            stk.pop();

            for (vector<int>& v : paths) {
                int src = v[0];
                int dst = v[1];
                int weight = v[2];

                if (now == src && !visited[dst]) {
                    visited[dst] = true;
                    stk.push(dst);
                }
            }
        }
    }



    return answer;
}

void internship_ex3() {
    int n = 6;
    vector<vector<int>> paths = {
            {1, 2, 3}, {2, 3, 5}, {2, 4, 2},
            {2, 5, 4}, {3, 4, 4}, {4, 5, 3},
            {4, 6, 1}, {5, 6, 1}
    };
    vector<int> gates = { 1, 3 };
    vector<int> summits = { 5 };

    solution(n, paths, gates, summits);
}