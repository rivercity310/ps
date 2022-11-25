import sys
from collections import deque


def solve(tree: list[list[int]]) -> None:
    q = deque()
    visited = [False] * len(tree)
    ans = [0] * len(tree)

    q.append(1)
    visited[1] = True

    while q:
        now = q.popleft()

        for next in tree[now]:
            if not visited[next]:
                q.append(next)
                visited[next] = True
                ans[next] = now

    for a in ans[2:]:
        print(a)


if __name__ == "__main__":
    input = sys.stdin.readline

    n = int(input())

    tree = [[] for _ in range(n + 1)]

    for i in range(n - 1):
        a, b = map(int, input().split())

        tree[a].append(b)
        tree[b].append(a)

    solve(tree)
