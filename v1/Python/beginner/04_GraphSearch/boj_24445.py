import sys
from collections import deque

input = sys.stdin.readline

def solve(grp: list[list[int]], start: int) -> None:
    visited = [False] * len(grp)
    visited[start] = True
    q = deque([start])

    ans = [0] * (len(grp))
    cnt = 1

    while q:
        now = q.popleft()
        ans[now] = cnt
        cnt += 1

        for nst in grp[now]:
            if not visited[nst]:
                visited[nst] = True
                q.append(nst)

    for i in range(1, len(ans)):
        print(ans[i])


if __name__ == "__main__":
    n, m, r = map(int, input().split())
    grp = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().split())
        grp[u].append(v)
        grp[v].append(u)

    for g in grp:
        g.sort(reverse=True)

    solve(grp, r)

        