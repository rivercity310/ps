import sys


def solve(x, y, size):
    tmp = paper[x][y]

    for a in range(x, x + size):
        for b in range(y, y + size):
            if paper[a][b] != tmp:

                size //= 3

                for i in range(3):
                    for j in range(3):
                        nx = x + (i * size)
                        ny = y + (j * size)
                        solve(nx, ny, size)

                return

    ans[tmp + 1] += 1


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    paper = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
    ans = [0, 0, 0]
    solve(0, 0, n)

    for a in ans:
        print(a)
