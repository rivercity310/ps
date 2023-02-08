import sys
from collections import deque

m, n = map(int, sys.stdin.readline().rstrip().split())
grp = []
q = deque()
ans = 0

for i in range(n):
    grp.append(list(map(int, sys.stdin.readline().rstrip().split())))

    for j, v in enumerate(grp[i]):
        if v == 1:
            q.append((i, j, 0))

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

while q:
    x, y, day = q.popleft()
    ans = day

    for a, b in zip(dx, dy):
        nx = x + a
        ny = y + b

        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue

        if grp[nx][ny] == 0:
            grp[nx][ny] = 1
            q.append((nx, ny, day + 1))

chk = True

for i in range(n):
    if 0 != grp[i].count(0):
        chk = False
        break

print(-1 if not chk else ans)
