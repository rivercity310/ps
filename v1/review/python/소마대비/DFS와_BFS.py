import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())
grp = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    grp[a].append(b)
    grp[b].append(a)

for i in range(n + 1):
    grp[i].sort()


def dfs(start):
    visited[start] = True
    print(start, end=' ')

    for node in grp[start]:
        if not visited[node]:
            dfs(node)


def bfs(start):
    global visited

    q = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True

    while q:
        now = q.popleft()
        print(now, end=" ")

        for node in grp[now]:
            if not visited[node]:
                visited[node] = True
                q.append(node)


dfs(v)
visited = [False] * (n + 1)
print()
bfs(v)
