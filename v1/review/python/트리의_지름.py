import sys


# 임의의 정점 a에서 가장 먼 정점 b를 구한다
# b에서 가장 먼 정정 c를 구하면 b-c 간의 거리가 트리의 지름
def dfs(start, dist):
    global max_dist, end

    visited[start] = True

    if dist > max_dist:
        max_dist = dist
        end = start

    for nxt, weight in grp[start]:
        if not visited[nxt]:
            dfs(nxt, dist + weight)


if __name__ == "__main__":
    sys.setrecursionlimit(10 ** 6)

    n = int(sys.stdin.readline())
    grp = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b, c = map(int, sys.stdin.readline().rstrip().split())
        grp[a].append((b, c))
        grp[b].append((a, c))

    max_dist = 0
    end = 0

    visited = [False] * (n + 1)
    dfs(1, 0)
    visited = [False] * (n + 1)
    dfs(end, 0)

    print(max_dist)
