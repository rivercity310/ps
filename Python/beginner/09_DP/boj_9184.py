import sys

input = sys.stdin.readline

MAX = 51
dp = [[[0] * MAX for _ in range(MAX)] for _ in range(MAX)] * MAX

def solve(a: int, b: int, c: int) -> int:
    if a <= 0 or b <= 0 or c <= 0:
        return 1

    if dp[a][b][c]:
        return dp[a][b][c]

    if a > 20 or b > 20 or c > 20:
        dp[20][20][20] = solve(20, 20, 20)
        return dp[20][20][20]

    if a < b < c:
        dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c)
        return dp[a][b][c]

    dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1)
    return dp[a][b][c]


while True:
    a, b, c = map(int, input().split())

    if a == -1 and b == -1 and c == -1:
        break

    print(f"w({a}, {b}, {c}) = {solve(a, b, c)}")
