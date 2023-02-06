import sys
from collections import deque

input = sys.stdin.readline
T = int(input())

def solve(ps):
    stk = deque()

    for c in ps:
        if c == '(':
            stk.append(c)
        elif c == ')':
            if len(stk) != 0:
                stk.pop()
            else:
                return "NO"

    return "YES" if len(stk) == 0 else "NO"


for i in range(T):
    ps = list(input().rstrip())
    if ps[0] == ')' or ps[-1] == '(':
        print("NO")
    else:
        print(solve(ps))
