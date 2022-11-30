//
// Created by seungsu on 11/30/22.
//

// 재귀를 이용한 방법 -> 시간초과

#include <iostream>
#include <vector>

using namespace std;

typedef unsigned long long ull;
typedef vector<vector<ull>> Matrix;

constexpr int MAX = 5;
constexpr int DIV = 1000;

static Matrix mat(MAX, vector<ull>(MAX));

static Matrix operator*(const Matrix& A, const Matrix& B) {
    int size = A.size();
    Matrix tmp(size, vector<ull>(size));

    for (int k = 0; k < size; k++) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                tmp[k][i] += (A[k][j] * B[j][i]) % DIV;
        }
    }

    return tmp;
}

static Matrix solve(const Matrix& A, ull times) {
    if (times == 1) return A;

    Matrix tmp = solve(A, times / 2);

    if (times & 1) {
        Matrix tmp2 = tmp * A;
        return tmp * tmp2;
    }

    return tmp * tmp;
}

void boj_10830() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    ull n, b;
    cin >> n >> b;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cin >> mat[i][j];
    }


    Matrix&& ans = solve(mat, b);

    for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++)
             cout << ans[i][j] % DIV << " ";
         cout << "\n";
    }
}
