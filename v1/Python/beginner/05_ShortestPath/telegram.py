# 간단한 다익스트라 문제
# 도시 c에서 보낸 메세지를 받게 되는 도시의 개수와 모두 메세지를 받는 데까지 걸리는 시간

import sys
import heapq


def solve(grp: list[list[tuple[int, int]]], start: int) -> None:
    q = []
    distance = [int(1e9)] * len(grp)

    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for weight, end_vertex in grp[now]:
            cost = distance[now] + weight

            if distance[end_vertex] > cost:
                distance[end_vertex] = cost
                heapq.heappush(q, (cost, end_vertex))

    cnt = 0
    for dist in distance[1:]:
        if dist != 0 and dist != int(1e9):
            cnt += 1

    print(cnt, end=" ")
    print(max(distance[1:]))


if __name__ == "__main__":
    input = sys.stdin.readline
    n, m, c = map(int, input().split())

    grp = [[] for _ in range(n + 1)]
    for _ in range(m):
        x, y, z = map(int, input().split())
        grp[x].append((z, y))       # x에서 y까지 가중치 z
        grp[y].append((z, x))

    solve(grp, c)