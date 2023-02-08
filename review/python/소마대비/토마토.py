import sys
from collections import deque

m, n = map(int, sys.stdin.readline().rstrip().split())
grp = []
spots = []
days = 0

for i in range(n):
    grp.append(list(map(int, sys.stdin.readline().rstrip().split())))
    for j, v in enumerate(grp[i]):
        if v == 1:
            spots.append((i, j))


def bfs(r, c):
    global days

    for spot in spots:
    


chk = True

for i in range(n):
    if 0 != grp[i].count(0):
        chk = False
        break

print(-1 if not chk else days)
