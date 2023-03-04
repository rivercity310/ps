import sys


n = int(sys.stdin.readline())
arr = [list(sys.stdin.readline().rstrip()) for _ in range(n)]


def solve(x, y, size):
    if size == 1:
        return arr[x][y]

    cnt = 0
    for i in range(x, x + size):
        for j in range(y, y + size):
            cnt += int(arr[i][j])

    if cnt == 0 or cnt == size ** 2:
        return "0" if cnt == 0 else "1"

    size //= 2

    return (
            "(" +
            solve(x, y, size) +
            solve(x, y + size, size) +
            solve(x + size, y, size) +
            solve(x + size, y + size, size) +
            ")"
    )


print(solve(0, 0, n))
