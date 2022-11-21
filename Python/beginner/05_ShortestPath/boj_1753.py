import sys
import heapq

input = sys.stdin.readline

def solve(grp: list[list[tuple[int, int]]], start: int) -> list[int]:
    q = []
    distance = [int(1e9)] * (len(grp))
    
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for end_vertex, weight in grp[now]:
            cost = distance[now] + weight

            if distance[end_vertex] > cost:
                distance[end_vertex] = cost
                heapq.heappush(q, (cost, end_vertex))

    return distance


if __name__ == '__main__':
    v, e = map(int, input().split())
    start = int(input())

    grp = [[] for _ in range(v + 1)]

    for _ in range(e):
        u, v, w = map(int, input().split())
        grp[u].append((v, w))

    distance = solve(grp, start)
    for i in range(1, len(distance)):
        if distance[i] == int(1e9):
            print("INF")
        else:
            print(distance[i])