import sys
import heapq

input = sys.stdin.readline

def solve(grp: list[list[tuple[int, int]]], n: int, start: int, end: int) -> int:
    INF = int(1e9)
    
    q = []
    distance = [INF] * (n + 1)
    
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for end_vertex, weight in grp[now]:
            cost = distance[now] + weight

            if cost < distance[end_vertex]:
                distance[end_vertex] = cost
                heapq.heappush(q, (cost, end_vertex))

    return distance[end]


if __name__ == '__main__':
    n = int(input())
    m = int(input())

    grp = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, w = map(int, input().split())
        grp[a].append((b, w))

    start, end = map(int, input().split())
    print(solve(grp, n, start, end))