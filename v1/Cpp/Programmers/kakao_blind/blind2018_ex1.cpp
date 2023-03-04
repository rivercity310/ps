//
// Created by seungsu on 12/12/22.
//

#include <bits/stdc++.h>

using namespace std;

int bl2018_ex1(string dartResult) {
    string str = "";
    vector<int> v;

    for (char c : dartResult) {
        if (c >= '0' && c <= '9') str += c;
        else if (c == 'S') v.push_back(stoi(str)), str = "";
        else if (c == 'D') v.push_back(pow(stoi(str), 2)), str = "";
        else if (c == 'T') v.push_back(pow(stoi(str), 3)), str = "";
        else if (c == '#') v.back() = -v.back();
        else if (c == '*') {
            if (v.size() > 1) v[v.size() - 2] *= 2;
            v.back() *= 2;
        }
    }

    return std::accumulate(v.begin(), v.end(), 0);
}