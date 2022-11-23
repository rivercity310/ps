import sys
from collections import deque

# [ 미로탈출 ]
# (1, 1)에서 (N, M)까지 괴물을 피해 이동 ->  0: 괴물이 있는 칸


def solve(grp: list[list[int]], n: int, m: int) -> None:
    q = deque()
    q.append((0, 0))

    # 사방탐색을 위한 벡터
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y = q.popleft()

        for kx, ky in zip(dx, dy):      # (1, 1) -> (0, 1), (2, 0), (1, 0), (1, 2)
            tx = x + kx
            ty = y + ky

            if tx < 0 or ty < 0 or tx >= len(grp) or ty >= len(grp[x]):
                continue

            if grp[tx][ty] == 1:
                grp[tx][ty] = grp[x][y] + 1
                q.append((tx, ty))

            ''' 
            - 단축 조건 : 만나면 바로 출력후 리턴
            if tx == n - 1 and ty == m - 1:
                print(grp[tx][ty])
                return
            '''

    grp[0][0] = 1
    for i in range(len(grp)):
        for j in range(len(grp[i])):
            print("%-5d" % (grp[i][j]), end="")
        print()

    print(grp[-1][-1])


if __name__ == "__main__":
    input = sys.stdin.readline
    n, m = map(int, input().split())

    grp = []
    for i in range(n):
        grp.append(list(map(int, input().rstrip())))

    solve(grp, n, m)
