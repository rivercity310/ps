import sys
from collections import deque

# https://www.acmicpc.net/problem/17952

input = sys.stdin.readline
N = int(input())
dq = deque()
score = 0

for i in range(N):
    ass = list(map(int, input().split()))

    if ass[0] == 0:
        if len(dq) != 0:
            tmp = dq.pop()
            tmp[1] -= 1

            if tmp[1] == 0:
                score += tmp[0]
            else:
                dq.append(tmp)

    else:
        if ass[2] - 1 == 0:
            score += ass[1]
        else:
            dq.append([ass[1], ass[2] - 1])

print(score)
