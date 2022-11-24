import sys

INF = int(1e9)


def solve(grp: list[list[int]]) -> int:
    for k in range(1, len(grp)):
        for i in range(1, len(grp)):
            for j in range(1, len(grp)):
                grp[i][j] = min(grp[i][j], grp[i][k] + grp[k][j])

    ans = INF

    for i in range(1, len(grp)):
        for j in range(1, len(grp)):
            if i == j: continue
            ans = min(ans, grp[i][j] + grp[j][i])

    return -1 if ans == INF else ans


if __name__ == "__main__":
    input = sys.stdin.readline
    v, e = map(int, input().split())

    grp = [[INF] * (v + 1) for _ in range(v + 1)]
    for _ in range(e):
        a, b, c = map(int, input().split())
        grp[a][b] = c

    print(solve(grp))
