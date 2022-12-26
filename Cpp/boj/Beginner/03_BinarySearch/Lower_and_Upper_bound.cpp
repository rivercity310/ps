//
// Created by seungsu on 22. 11. 20.
//

#include <iostream>
#include <vector>

using namespace std;

static int lower_bound(vector<int>& v, int key) {
    int left = 0;
    int right = v.size();

    while (left < right) {
        int mid = (left + right) / 2;
        if (v[mid] >= key) right = mid;
        else left = mid + 1;
    }

    return right;
}

static int upper_bound(vector<int>& v, int key) {
    int left = 0;
    int right = v.size();

    while (left < right) {
        int mid = (left + right) / 2;
        if (v[mid] > key) right = mid;
        else left = mid + 1;
    }

    return right;
}

void lower_and_upper_bound_test() {
    vector<int> v{1, 3, 5, 7, 9, 11, 13, 15, 15, 15, 15, 17, 19};
    int key = 15;

    cout << lower_bound(v, key) << "\n";
    cout << upper_bound(v, key) << "\n";
}