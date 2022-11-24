import sys
from collections import deque


def solve(grp: list[list[int]], start: int) -> None:
    q = deque()
    visited = [False] * len(grp)
    ans = [0] * len(grp)
    cnt = 1

    q.append(start)
    visited[start] = True

    while q:
        now = q.popleft()
        ans[now] = cnt
        cnt += 1

        for k in grp[now]:
            if not visited[k]:
                q.append(k)
                visited[k] = True

    for i in range(1, len(ans)):
        print(ans[i])


if __name__ == "__main__":
    input = sys.stdin.readline
    n, m, r = map(int, input().split())

    arr = [[] for _ in range(n + 1)]

    for _ in range(m):
        u, v = map(int, input().split())
        arr[u].append(v)
        arr[v].append(u)

    for a in arr:
        a.sort()

    solve(arr, r)