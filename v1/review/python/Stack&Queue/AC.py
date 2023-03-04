import sys
from collections import deque

input = sys.stdin.readline
T = int(input())


def solve(ops, dq):
    rvs = 0

    for op in ops:
        if op == 'R':
            rvs += 1
        elif op == 'D':
            if len(dq) == 0:
                print("error")
                return

            if rvs % 2 == 0:
                dq.popleft()
            else:
                dq.pop()

    if rvs % 2 != 0:
        dq.reverse()

    print('[' + ','.join(dq) + ']')


while T:
    ops = list(input())
    n = int(input())
    dq = deque(input()[1:-2].split(','))

    if n == 0:
        dq.pop()

    solve(ops, dq)
    T -= 1

