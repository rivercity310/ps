import sys
import heapq

input = sys.stdin.readline

def solve(grp: list[list[tuple[int]]], start: int, end: int) -> int:
    q = []
    distance = [int(1e9)] * (len(grp) + 1)

    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for tup in grp[now]:
            for t in tup:
                if t >= max(start, end) * 2:
                    continue

                weight = 0 if now * 2 == t else 1
                cost = distance[now] + weight

                if distance[t] > cost:
                    distance[t] = cost
                    heapq.heappush(q, (cost, t))

    return distance[end]

if __name__ == "__main__":
    n, k = map(int, input().split())

    # 모든 i번 노드에는 i - 1, i + 1, 2i 노드가 연결되어 있다. 
    # i - 1과 i + 1은 가중치가 1이고, 2i은 가중치가 0이다.

    m = max(n, k)

    grp = [[] for _ in range((2 * m) + 1)]
    grp[0] = [(0, 1)]

    for i in range(1, len(grp)):
        if i + 1 == 2 * i:
            grp[i].append((i - 1, i + 1))
        else:
            grp[i].append((i - 1, i + 1, 2 * i))

    print(solve(grp, n, k))
     