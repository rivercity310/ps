import sys
from collections import deque


n, p = map(int, sys.stdin.readline().split())
guitar = [deque() for _ in range(6)]
cnt = 0

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    a -= 1
    line = guitar[a]

    if len(line) == 0:
        line.append(b)
        cnt += 1

    elif b > line[-1]:
        line.append(b)
        cnt += 1

    else:
        while len(line) != 0 and line[-1] > b:
            line.pop()
            cnt += 1

        if len(line) == 0:
            line.append(b)
            cnt += 1

        elif line[-1] != b:
            line.append(b)
            cnt += 1


print(cnt)
