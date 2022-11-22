//
// Created by seungsu on 22. 11. 22.
//

#include <iostream>

using namespace std;

static int ans = -1;
static int cnt = 0;

static void merging(int* arr, int left, int mid, int right, int k) {
    int* tmp = new int[right + 2];

    int i = left;
    int j = mid + 1;
    int t = left;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
        else tmp[t++] = arr[j++];
    }

    while (i <= mid)
        tmp[t++] = arr[i++];

    while (j <= right)
        tmp[t++] = arr[j++];

    for (int a = left; a <= right; a++) {
        if (++cnt == k) {
            ans = tmp[a];
            break;
        }

        arr[a] = tmp[a];
    }

    delete[] tmp;
}

static void merge_sort(int* arr, int left, int right, int k) {
    if (left < right) {
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid, k);
        merge_sort(arr, mid + 1, right, k);
        merging(arr, left, mid, right, k);
    }
}

void boj_24060() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, k;
    cin >> n >> k;

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    merge_sort(arr, 0, n - 1, k);
    cout << ans;

    delete[] arr;
}