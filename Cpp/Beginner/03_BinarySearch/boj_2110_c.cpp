#include <stdio.h>
#include <stdlib.h>

static int install(int* arr, int n, int mid) {
    int router = 1;
    int last = arr[0];

    for (int i = 1; i < n; i++) {
        int loc = arr[i];

        if (loc >= last + mid) {
            router++;
            last = loc;
        }
    }

    return router;
}

static int solve(int* arr, int n, int c) {
    int left = 1;
    int right = arr[n - 1] - arr[0] + 1;

    while (left < right) {
        int mid = (left + right) / 2;
        int router = install(arr, n, mid);

        if (router < c) right = mid;
        else left = mid + 1;
    }

    return right - 1;
}

static int compare(const void* first, const void* second) {
    int a = *(int*)first;
    int b = *(int*)second;

    return a - b;
}

void boj_2110_c() {
    int n, c;
    scanf("%d %d", &n, &c);

    int* arr = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    qsort(arr, n, sizeof(int), compare);

    printf("%d", solve(arr, n, c));
    free(arr);
}