import sys

n = int(sys.stdin.readline())
grp = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]
ans = []
cnt = 0


def dfs(r, c):
    global cnt

    if r < 0 or c < 0 or r >= n or c >= n:
        return False

    if grp[r][c]:
        grp[r][c] = 0
        cnt += 1

        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)

        return True

    return False


for i in range(n):
    for j in range(n):
        if grp[i][j]:
            dfs(i, j)
            ans.append(cnt)
            cnt = 0

print(len(ans))
for a in sorted(ans):
    print(a)
