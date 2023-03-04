import sys
from collections import deque


def solve(grp: list[list[int]], start: int, end: int, m: int) -> None:
    q = deque()
    visited = [False] * len(grp)
    distance = [int(1e9)] * len(grp)

    q.append(start)
    visited[start] = True
    distance[start] = 0

    while q:
        now = q.popleft()

        for k in grp[now]:
            if k >= m * 2:
                continue

            if not visited[k]:
                cost = distance[now] + 1

                if distance[k] > cost:
                    distance[k] = cost
                    q.append(k)
                    visited[k] = True

    print(distance[end])


if __name__ == "__main__":
    input = sys.stdin.readline

    n, k = map(int, input().split())
    if n == k:
        print("0")
    elif abs(n - k) == 1:
        print("1")
    else:
        m = max(n, k)

        grp = [[] for _ in range(m * 2 + 1)]
        grp[0] = [1]
        grp[1] = [0, 2]

        for i in range(2, len(grp)):
            grp[i] = [i - 1, i + 1, i * 2]

        solve(grp, n, k, m)
