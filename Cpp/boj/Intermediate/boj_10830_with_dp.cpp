//
// Created by seungsu on 11/30/22.
//

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

constexpr int MAX = 5;
constexpr int DIV = 1000;

typedef unsigned long long ull;
typedef vector<vector<ull>> Matrix;

static int N;
static ull Times;
static unordered_map<ull, Matrix> dp;

static Matrix matmul(const Matrix& A, const Matrix& B) {
    Matrix ret(N, vector<ull>(N, 0));

    for (int k = 0; k < N; k++)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret[k][i] += (A[k][j] * B[j][i]) % DIV;
            }
        }

    return ret;
}

static Matrix solve(Matrix& arr, ull times) {
    if (times == 1) return arr;
    if (dp.find(times) != dp.end()) return dp[times];
    if (times & 1) return dp[times] = matmul(arr, solve(arr, times - 1));
    return dp[times] = matmul(solve(arr, times / 2), solve(arr, times / 2));
}

void boj_10830_with_dp() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N >> Times;

    Matrix A(N, vector<ull>(N));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> A[i][j];

    Matrix&& ans = solve(A, Times);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            cout << ans[i][j] % DIV << " ";
        cout << "\n";
    }
}
