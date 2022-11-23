import sys

# [ 플로이드 워셜 알고리즘 ] -> 인접행렬 방식
# 다익스트라를 n번 수행 -> i번 노드에서 다른 모든 노드까지의 최단거리 (i = 1, 2, ....)


def solve(grp: list[list[int]]):
    size = len(grp)

    for k in range(1, size):
        for a in range(1, size):
            for b in range(1, size):
                grp[a][b] = min(grp[a][k] + grp[k][b], grp[a][b])

    for a in range(1, size):
        for b in range(1, size):
            if grp[a][b] == int(1e9): print(-1, end=" ")
            else: print(grp[a][b], end=" ")
        print()


if __name__ == "__main__":
    n, e = map(int, input().split())

    grp = [[int(1e9)] * (n + 1) for _ in range(n + 1)]

    for a in range(1, len(grp)):
        for b in range(1, len(grp)):
            if a == b:
                grp[a][b] = 0

    for _ in range(e):
        x, y, w = map(int, input().split())
        grp[x][y] = w

    solve(grp)
