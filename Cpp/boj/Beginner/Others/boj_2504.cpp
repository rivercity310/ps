//
// Created by seungsu on 11/28/22.
//

#include <iostream>
#include <vector>
#include <deque>

using namespace std;

void boj_2504() {
    string str;
    cin >> str;

    if (str.size() % 2 != 0) {
        cout << 0;
        return;
    }

    if (str[str.size() - 1] == '(' || str[str.size() - 1] == '[') {
        cout << 0;
        return;
    }

    deque<char> dq;
    int left = 0;
    int right = str.size() - 1;

    for (char c : str) {

    }
}