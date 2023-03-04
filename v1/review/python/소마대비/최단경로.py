import sys
import heapq

v, e = map(int, sys.stdin.readline().split())
k = int(sys.stdin.readline())
inf = int(1e9)
grp = [[] for _ in range(v + 1)]
distance = [inf] * (v + 1)

for _ in range(e):
    u, v, w = map(int, sys.stdin.readline().split())
    grp[u].append((v, w))


def dijk(start):
    pq = []
    heapq.heappush(pq, (0, start))
    distance[start] = 0

    while pq:
        dist, now = heapq.heappop(pq)

        if dist > distance[now]:
            continue

        for node, weight in grp[now]:
            cost = distance[now] + weight

            if distance[node] > cost:
                distance[node] = cost
                heapq.heappush(pq, (cost, node))


dijk(k)

for d in distance[1:]:
    print("INF" if d == inf else str(d))
