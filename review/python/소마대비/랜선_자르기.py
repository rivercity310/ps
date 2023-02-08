import sys

k, n = map(int, sys.stdin.readline().rstrip().split())
lines = [int(sys.stdin.readline()) for _ in range(k)]


def solve():
    bottom = 1
    top = max(lines)

    while bottom <= top:
        mid = (bottom + top) // 2
        cnt = 0

        for line in lines:
            cnt += line // mid

        if cnt >= n:
            bottom = mid + 1
        else:
            top = mid - 1

    return top


print(solve())
